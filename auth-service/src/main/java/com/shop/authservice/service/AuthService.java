package com.shop.authservice.service;

import com.shop.authservice.dto.request.RefreshTokenDTO;
import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.response.AuthResponse;
import com.shop.authservice.entity.Auth;

public interface AuthService {
    AuthResponse login(LoginDTO loginDTO);

//    AuthResponse refreshToken(String refreshToken);
    AuthResponse refreshToken(RefreshTokenDTO refreshToken);
}