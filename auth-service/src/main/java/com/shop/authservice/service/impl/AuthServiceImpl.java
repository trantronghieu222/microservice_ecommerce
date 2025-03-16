package com.shop.authservice.service.impl;

import com.nimbusds.jose.JOSEException;
import com.shop.authservice.client.AccountClient;
import com.shop.authservice.common.Role;
import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.response.ApiResponse;
import com.shop.authservice.dto.response.AuthResponse;
import com.shop.authservice.entity.Auth;
import com.shop.authservice.exception.AppException;
import com.shop.authservice.exception.ErrorCode;
import com.shop.authservice.repository.AuthRepository;
import com.shop.authservice.service.AuthService;
import com.shop.authservice.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private ModelMapper modelMapper;

    private String getAuthServiceToken() {
        WebClient webClient = WebClient.builder().build();
        LoginDTO systemLogin = new LoginDTO("tranhieu123", "12345"); // Định nghĩa tài khoản hệ thống

        ApiResponse<AuthResponse> response = webClient.post()
                .uri("http://localhost:8080/auth-service/auth/login") // Gọi API login để lấy Token
                .bodyValue(systemLogin)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<AuthResponse>>() {})
                .block();

        if (response == null || response.getStatus() != 200 || response.getContent() == null) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        return response.getContent().getAccessToken(); // Lấy token từ "content"
    }

//    @Override
//    public AuthResponse login(LoginDTO loginDTO) {
//        // Gọi Account Service để lấy thông tin tài khoản
//        ApiResponse<AccountResponse> response = accountClient.getAccountByUsername(loginDTO.getUsername());
//
//        if (response == null || response.getStatus() != 200 || response.getContent() == null) {
//            throw new AppException(ErrorCode.USER_NOT_FOUND);
//        }
//
//        AccountResponse accountResponse = response.getContent();
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        // Kiểm tra mật khẩu
//        if (!passwordEncoder.matches(loginDTO.getPassword(), accountResponse.getPassword())) {
//            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
//        }
//
//        try {
//            // Tạo JWT token
//            String token = jwtUtil.generateToken(accountResponse.getAccountId(), response.getContent().getRole());
//
//            // Trả về AuthResponse chứa token
//            AuthResponse authResponse = new AuthResponse();
//            authResponse.setAccessToken(token);
//            return authResponse;
//        } catch (JOSEException e) {
//            throw new AppException(ErrorCode.JWT_TOKEN_CREATION_FAILED);
//        }
//    }

    @Override
    public AuthResponse login(LoginDTO loginDTO) {
        // Gọi Account Service để lấy thông tin tài khoản
        AccountResponse accountResponse = accountClient.getAccountByUsername(loginDTO.getUsername());

        if (accountResponse == null) {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(loginDTO.getPassword(), accountResponse.getPassword())) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        try {
            // Tạo JWT token
            String token = jwtUtil.generateToken(accountResponse.getAccountId(), accountResponse.getRole());

            // Trả về AuthResponse chứa token
            AuthResponse authResponse = new AuthResponse();
            authResponse.setAccessToken(token);
            return authResponse;
        } catch (JOSEException e) {
            throw new AppException(ErrorCode.JWT_TOKEN_CREATION_FAILED);
        }
    }

//    @Override
//    public Auth register(Auth request) {
//        // Kiểm tra xem username đã tồn tại chưa
//        if (authRepository.existsByUsername(request.getUsername())) {
//            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
//        }
//
//        AccountResponse accountDTO = modelMapper.map(request, AccountResponse.class);
//        accountClient.createAccount(accountDTO);
//
//        return authRepository.save(request);
//    }

    @Override
    public Auth register(Auth request) {
        // Kiểm tra xem username đã tồn tại chưa
        if (authRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        AccountResponse accountDTO = modelMapper.map(request, AccountResponse.class);

        try {
            String token = jwtUtil.generateToken(1, Role.ADMIN);
            // Gửi request kèm Token
            accountClient.createAccount(accountDTO, "Bearer " + token);
            return authRepository.save(request);
        } catch (JOSEException e) {
            e.printStackTrace(); // In ra lỗi để debug
            throw new RuntimeException("Lỗi tạo JWT token", e);
        }
    }
}
