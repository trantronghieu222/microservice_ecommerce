package com.shop.authservice.controller;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.request.RefreshTokenDTO;
import com.shop.authservice.dto.response.ApiResponse;
import com.shop.authservice.dto.response.AuthResponse;
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
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login (
            @RequestBody LoginDTO loginDTO
    ){
        AuthResponse authResponse = authService.login(loginDTO);
        ApiResponse<AuthResponse> apiResponse = ApiResponse.createResponse(authResponse, "Đăng nhập thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RefreshTokenDTO refreshToken){

        AuthResponse authResponse = authService.refreshToken(refreshToken);
        ApiResponse<AuthResponse> apiResponse = ApiResponse.createResponse(authResponse, "thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}