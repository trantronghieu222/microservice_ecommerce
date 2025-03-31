package com.shop.authservice.service.impl;

import com.nimbusds.jose.JOSEException;
import com.shop.authservice.client.AccountClient;
import com.shop.authservice.common.Role;
import com.shop.authservice.dto.request.RefreshTokenDTO;
import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.response.AuthResponse;
import com.shop.authservice.exception.AppException;
import com.shop.authservice.exception.ErrorCode;
import com.shop.authservice.service.AuthService;
import com.shop.authservice.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Autowired
    private AccountClient accountClient;

    @Override
    public AuthResponse login(LoginDTO loginDTO) {
        // Gọi Account Service để lấy thông tin tài khoản
        AccountResponse response = accountClient.getAccountByUsername(loginDTO.getUsername());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(loginDTO.getPassword(), response.getPassword())) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        try {
            // Tạo JWT token
            String token = jwtUtil.generateToken(response.getAccountId(), response.getRole());
            String refreshToken = jwtUtil.generateRefreshToken(response.getAccountId(), response.getRole());

            // Trả về AuthResponse chứa token
            AuthResponse authResponse = new AuthResponse();
            authResponse.setAccessToken(token);
            authResponse.setRefreshToken(refreshToken);
            return authResponse;
        } catch (JOSEException e) {
            throw new AppException(ErrorCode.JWT_TOKEN_CREATION_FAILED);
        }
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenDTO refreshTokenDTO) {
        String refreshToken = refreshTokenDTO.getRefreshToken();

        if (!jwtUtil.validateToken(refreshToken)) {
            throw new AppException(ErrorCode.INVALID_JWT_TOKEN);
        }

        Integer userId = jwtUtil.extractId(refreshToken);

        String[] rolesArray = jwtUtil.extractRoles(refreshToken);

        if (rolesArray == null || rolesArray.length == 0) {
            throw new AppException(ErrorCode.INVALID_JWT_TOKEN);
        }

        String roleString = rolesArray[0].trim();

        try {
            AuthResponse authResponse = new AuthResponse();
            String newAccessToken = jwtUtil.generateToken(userId, Role.valueOf(roleString));
            authResponse.setAccessToken(newAccessToken);
            authResponse.setRefreshToken(refreshToken);
            return authResponse;
        } catch (JOSEException e) {
            throw new AppException(ErrorCode.JWT_TOKEN_CREATION_FAILED);
        }
    }
}