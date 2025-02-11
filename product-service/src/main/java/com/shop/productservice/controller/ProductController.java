package com.shop.productservice.controller;
import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.dto.response.ApiResponse;
import com.shop.productservice.entity.Product;
import com.shop.productservice.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
@Tag(name = "Product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProduct(){
        List<Product> products = productService.findAll();
        ApiResponse<List<Product>> apiResponse = ApiResponse.createResponse(products, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(
            @RequestParam Integer id
    ){
        Product product = productService.findById(id);
        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(
            @RequestBody ProductCreate request
    ){
        Product product = productService.save(request);
        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Thêm sản phẩm thành công!", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @RequestParam Integer id,
            @RequestBody ProductCreate request
    ){
        Product product = productService.update(id, request);
        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Cập nhật sản phẩm thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(
            @RequestParam Integer id
    ){
        productService.delete(id);
        ApiResponse<Object> apiResponse = ApiResponse.createResponse(null, "Xoá sản phẩm thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
