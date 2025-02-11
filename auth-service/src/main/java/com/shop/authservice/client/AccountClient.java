package com.shop.authservice.client;

import com.shop.authservice.dto.response.AccountResponse;
import com.shop.authservice.dto.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service", url = "http://localhost:8081/Account")
public interface AccountClient {
    @PostMapping
    void createAccount(@RequestBody AccountResponse accountDTO);

    @GetMapping("/Existing")
    ApiResponse<AccountResponse> getAccountByUsername(@RequestParam String Username);
}
