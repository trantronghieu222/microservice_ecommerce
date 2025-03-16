package com.shop.authservice.client;

import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service")
public interface AccountClient {
//    @PostMapping("/account")
//    void createAccount(@RequestBody AccountResponse accountDTO);

    @PostMapping("/account")
    void createAccount(@RequestBody AccountResponse accountDTO,
                       @RequestHeader("Authorization") String token);

//    @GetMapping("/account/existing")
//    ApiResponse<AccountResponse> getAccountByUsername(@RequestParam String Username);

    @GetMapping("/account/existing")
    AccountResponse getAccountByUsername(@RequestParam String Username);
}
