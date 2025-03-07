package com.shop.orderservice.client;

import com.shop.orderservice.dto.request.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/product/{id}")
    void getProductById (@PathVariable Integer id);

    @GetMapping("/product/check-stock/{id}")
    Boolean checkStock(@PathVariable Integer id, @RequestParam Integer prodQuan);

    @PutMapping("/product")
    void updateProduct(@RequestBody Product productDTO);
}
