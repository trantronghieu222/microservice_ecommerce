package com.shop.authservice.client;

import com.shop.authservice.dto.response.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service")
public interface AccountClient {
    @GetMapping("/account/existing")
    AccountResponse getAccountByUsername(@RequestParam String Username);
}
