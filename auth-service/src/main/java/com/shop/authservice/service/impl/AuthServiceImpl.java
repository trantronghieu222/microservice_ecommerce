package com.shop.authservice.service.impl;

import com.shop.authservice.client.AccountClient;
import com.shop.authservice.dto.AccountDTO;
import com.shop.authservice.dto.LoginDTO;
import com.shop.authservice.entity.Auth;
import com.shop.authservice.exception.AppException;
import com.shop.authservice.exception.ErrorCode;
import com.shop.authservice.repository.AuthRepository;
import com.shop.authservice.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Auth login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public Auth register(Auth request) {
        // Kiểm tra xem username đã tồn tại chưa
        if (authRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        AccountDTO accountDTO = modelMapper.map(request, AccountDTO.class);
        accountClient.createAccount(accountDTO);

        return authRepository.save(request);
    }
}
