package com.shop.authservice.controller;

import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.response.ApiResponse;
import com.shop.authservice.dto.response.AuthResponse;
import com.shop.authservice.entity.Auth;
import com.shop.authservice.service.impl.AuthServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
@Tag(name = "Auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/Login")
    public ResponseEntity<ApiResponse<AuthResponse>> login (
            @RequestBody LoginDTO loginDTO
    ){
        AuthResponse authResponse = authService.login(loginDTO);
        ApiResponse<AuthResponse> apiResponse = ApiResponse.createResponse(authResponse, "Đăng nhập thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/Register")
    public ResponseEntity<ApiResponse<Auth>> register(@RequestBody Auth request){
        Auth auth = authService.register(request);
        ApiResponse<Auth> apiResponse = ApiResponse.createResponse(auth, "Đăng ký thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
