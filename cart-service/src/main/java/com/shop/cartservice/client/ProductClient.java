package com.shop.cartservice.client;

import com.shop.cartservice.dto.request.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "http://localhost:8082/Product")
public interface ProductClient {
    @GetMapping("/{id}")
    void getProductById(@RequestParam Integer id);
}
