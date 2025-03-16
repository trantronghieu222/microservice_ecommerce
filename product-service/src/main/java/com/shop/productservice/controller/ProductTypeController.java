package com.shop.productservice.controller;

import com.shop.productservice.dto.request.ProductTypeCreate;
import com.shop.productservice.dto.response.ApiResponse;
import com.shop.productservice.entity.ProductType;
import com.shop.productservice.service.impl.ProductTypeServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productType")
@Tag(name = "ProductType")
public class ProductTypeController {
    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductType>>> getAllProductType(){
        List<ProductType> productTypes = productTypeService.findAll();
        ApiResponse<List<ProductType>> apiResponse = ApiResponse.createResponse(productTypes, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductType>> getProductById(
            @RequestParam Integer id
    ){
        ProductType productType = productTypeService.findById(id);
        ApiResponse<ProductType> apiResponse = ApiResponse.createResponse(productType, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping
    public ResponseEntity<ApiResponse<ProductType>> createProductType(
            @RequestBody ProductTypeCreate request
    ){
        ProductType productType = productTypeService.save(request);
        ApiResponse<ProductType> apiResponse = ApiResponse.createResponse(productType, "Thêm thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ApiResponse<ProductType> createProductType(
//            @RequestBody ProductTypeCreate request
//    ){
//        ApiResponse<ProductType> apiResponse = new ApiResponse<>();
//        ProductType productType = productTypeService.save(request);
//        apiResponse.setData(productType);
//
//        return apiResponse;
//    }

    @SecurityRequirement(name = "BearerAuth")
    @PutMapping
    public ResponseEntity<ApiResponse<ProductType>> updateProductType(
            @RequestParam Integer id,
            @RequestBody ProductTypeCreate request
    ){
        ProductType productType = productTypeService.update(id, request);
        ApiResponse<ProductType> apiResponse = ApiResponse.createResponse(productType, "Cập nhật thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteProductType(
            @RequestParam Integer id
    ){
        productTypeService.delete(id);
        ApiResponse<Void> apiResponse = ApiResponse.createResponse(null, "Xoá thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
