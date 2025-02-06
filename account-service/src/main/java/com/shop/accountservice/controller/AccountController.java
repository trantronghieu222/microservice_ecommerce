package com.shop.accountservice.controller;

import com.shop.accountservice.dto.request.AccountDTO;
import com.shop.accountservice.dto.response.ApiResponse;
import com.shop.accountservice.entity.Account;
import com.shop.accountservice.service.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Account")
@Tag(name = "Account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Account>>> getAllAccount(){
        List<Account> accounts = accountService.findAll();
        ApiResponse<List<Account>> apiResponse = ApiResponse.createResponse(accounts, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> getAccountById(
            @RequestParam Integer id
    ){
        Account account = accountService.findById(id);
        ApiResponse<Account> apiResponse = ApiResponse.createResponse(account, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Account>> createAccount(
            @RequestBody AccountDTO request
    ){
        Account account = accountService.create(request);
        ApiResponse<Account> apiResponse = ApiResponse.createResponse(account, "Thêm tài khoản thành công!", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
