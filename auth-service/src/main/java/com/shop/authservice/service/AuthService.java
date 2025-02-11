package com.shop.authservice.service;

import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.response.AuthResponse;
import com.shop.authservice.entity.Auth;

public interface AuthService {
    AuthResponse login(LoginDTO loginDTO);

    Auth register(Auth auth);
}
