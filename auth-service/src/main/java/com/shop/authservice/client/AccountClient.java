package com.shop.authservice.client;

import com.shop.authservice.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service", url = "http://localhost:8081/Account")
public interface AccountClient {
    @PostMapping
    void createAccount(@RequestBody AccountDTO accountDTO);
}
