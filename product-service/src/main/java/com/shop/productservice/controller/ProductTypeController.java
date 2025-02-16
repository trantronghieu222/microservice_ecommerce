package com.shop.productservice.controller;

import com.shop.productservice.dto.request.ProductTypeCreate;
import com.shop.productservice.entity.ProductType;
import com.shop.productservice.service.impl.ProductTypeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductType> getAllProductType(){
        return productTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductById(
            @RequestParam Integer id
    ){
        return ResponseEntity.ok(productTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProductType(
            @RequestBody ProductTypeCreate request
    ){
//        ProductType productType = productTypeService.save(request);
        return ResponseEntity.ok(request);
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

    @PutMapping
    public ResponseEntity<ProductType> updateProductType(
            @RequestParam Integer id,
            @RequestBody ProductTypeCreate request
    ){
        ProductType productType = productTypeService.update(id, request);
        return ResponseEntity.ok(productType);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductType(
            @RequestParam Integer id
    ){
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
