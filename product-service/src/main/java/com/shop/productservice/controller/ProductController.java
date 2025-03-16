package com.shop.productservice.controller;
import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.dto.response.ApiResponse;
import com.shop.productservice.entity.Product;
import com.shop.productservice.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@Tag(name = "Product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProduct(){
        List<Product> products = productService.findAll();
        ApiResponse<List<Product>> apiResponse = ApiResponse.createResponse(products, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(
            @PathVariable Integer id
    ){
        Product product = productService.findById(id);
        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/search-paging")
    public ResponseEntity<ApiResponse<Object>> searchAccounts(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Page<Product> page = productService.searchPagingProduct(keyword, pageIndex, pageSize);

        Map<String, Object> response = new HashMap<>();
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        response.put("currentPage", pageIndex);
        response.put("content", page.getContent());

        ApiResponse<Object> apiResponse = ApiResponse.createResponse(response, "Thành công", HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(
            @RequestBody ProductCreate request
    ){
        Product product = productService.save(request);
        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Thêm sản phẩm thành công!", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<Product>> updateProduct(
//            @PathVariable Integer id,
//            @RequestBody ProductCreate request
//    ){
//        Product product = productService.update(id, request);
//        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Cập nhật sản phẩm thành công!", HttpStatus.OK.value());
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

    @SecurityRequirement(name = "BearerAuth")
    @PutMapping
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @RequestBody Product request
    ){
        Product product = productService.updateProduct(request);
        ApiResponse<Product> apiResponse = ApiResponse.createResponse(product, "Cập nhật sản phẩm thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(
            @PathVariable Integer id
    ){
        productService.delete(id);
        ApiResponse<Object> apiResponse = ApiResponse.createResponse(null, "Xoá sản phẩm thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/check-stock/{id}")
    public Boolean checkStock(
            @PathVariable Integer id,
            @RequestParam Integer prodQuan
    ){
        Product product = productService.findById(id);
        return product.getProductInventory() >= prodQuan;
    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping(value = "/upload-image/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload hình ảnh sản phẩm", description = "Upload file ảnh cho sản phẩm với ID cụ thể")
    public ResponseEntity<ApiResponse<?>> uploadProductImage(
            @PathVariable Integer id,
            @RequestPart("file")
            @Parameter(description = "File ảnh sản phẩm cần upload", required = true) MultipartFile file) {

        Product updatedProduct = productService.uploadProductImage(id, file);
        ApiResponse<?> apiResponse = ApiResponse.createResponse(updatedProduct, "Upload thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping(value = "/upload-image-cloud/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload hình ảnh sản phẩm", description = "Upload file ảnh cho sản phẩm với ID cụ thể")
    public ResponseEntity<ApiResponse<?>> uploadImage(
            @PathVariable Integer id,
            @RequestPart("file")
            @Parameter(description = "File ảnh sản phẩm cần upload", required = true) MultipartFile file) {
        Product updatedProduct = productService.uploadImage(id, file);
        ApiResponse<?> apiResponse = ApiResponse.createResponse(updatedProduct, "Upload thành công", HttpStatus.OK.value());
//        productService.uploadImage(id, file);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
