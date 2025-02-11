package com.shop.receivedservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-service", url = "http://localhost:8081/Account")
public interface AccountClient {
    @GetMapping("/{id}")
    void getAccountById(@RequestParam Integer id);
}
