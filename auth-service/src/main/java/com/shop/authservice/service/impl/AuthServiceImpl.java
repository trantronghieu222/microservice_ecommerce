package com.shop.authservice.service.impl;

import com.nimbusds.jose.JOSEException;
import com.shop.authservice.client.AccountClient;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthResponse login(LoginDTO loginDTO) {
        // Gọi Account Service để lấy thông tin tài khoản
        ApiResponse<AccountResponse> response = accountClient.getAccountByUsername(loginDTO.getUsername());

        if (response == null || response.getStatus() != 200 || response.getContent() == null) {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }

        AccountResponse accountResponse = response.getContent();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(loginDTO.getPassword(), accountResponse.getPassword())) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        try {
            // Tạo JWT token
            String token = JwtUtil.generateToken(accountResponse.getUsername(), response.getContent().getRole());

            // Trả về AuthResponse chứa token
            AuthResponse authResponse = new AuthResponse();
            authResponse.setAccessToken(token);
            return authResponse;
        } catch (JOSEException e) {
            throw new AppException(ErrorCode.JWT_TOKEN_CREATION_FAILED);
        }
    }

    @Override
    public Auth register(Auth request) {
        // Kiểm tra xem username đã tồn tại chưa
        if (authRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        AccountResponse accountDTO = modelMapper.map(request, AccountResponse.class);
        accountClient.createAccount(accountDTO);

        return authRepository.save(request);
    }
}
