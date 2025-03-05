package com.shop.accountservice.controller;

import com.shop.accountservice.dto.request.AccountDTO;
import com.shop.accountservice.dto.request.AccountUpdateDTO;
import com.shop.accountservice.dto.response.AccountResponseDTO;
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
@RequestMapping("/account")
@Tag(name = "Account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

//    @GetMapping
//    public ResponseEntity<ApiResponse<List<Account>>> findAllAccount(){
//        List<Account> accounts = accountService.findAll();
//        ApiResponse<List<Account>> apiResponse = ApiResponse.createResponse(accounts, "Thành công!", HttpStatus.OK.value());
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Account>>> getAllAccount(){
        List<Account> accounts = accountService.getAll();
        ApiResponse<List<Account>> apiResponse = ApiResponse.createResponse(accounts, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> getAccountById(
            @PathVariable Integer id
    ){
        Account account = accountService.findById(id);
        ApiResponse<Account> apiResponse = ApiResponse.createResponse(account, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/existing")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> getAccountByUsername(
            @RequestParam String Username
    ){
        AccountResponseDTO account = accountService.findByUsername(Username);
        ApiResponse<AccountResponseDTO> apiResponse = ApiResponse.createResponse(account, "Thành công!", HttpStatus.OK.value());
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

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> updateAccount(
            @RequestParam Integer UserId,
            @RequestBody AccountUpdateDTO accountUpdateDTO
            ){
        Account account = accountService.update(UserId, accountUpdateDTO);
        ApiResponse<Account> apiResponse = ApiResponse.createResponse(account, "Cập nhật thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteAccount(
            @RequestParam Integer UserId
    ){
        accountService.delete(UserId);
        ApiResponse<Object> apiResponse = ApiResponse.createResponse(null, "Xoá thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
