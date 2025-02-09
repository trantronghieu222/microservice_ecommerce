package com.shop.authservice.service;

import com.shop.authservice.dto.AccountDTO;
import com.shop.authservice.dto.LoginDTO;
import com.shop.authservice.entity.Auth;

public interface AuthService {
    Auth login(LoginDTO loginDTO);

    Auth register(Auth auth);

}
