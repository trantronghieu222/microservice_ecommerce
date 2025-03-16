package com.shop.productservice.controller;

import com.shop.productservice.dto.request.SupplierCreate;
import com.shop.productservice.dto.response.ApiResponse;
import com.shop.productservice.entity.Supplier;
import com.shop.productservice.service.impl.SupplierServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@Tag(name = "Supplier")
public class SupplierController {
    @Autowired
    private SupplierServiceImpl supplierService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Supplier>>> getAllSupplier(){
        List<Supplier> suppliers = supplierService.findAll();
        ApiResponse<List<Supplier>> apiResponse = ApiResponse.createResponse(suppliers, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Supplier>> getSupplierById(@RequestParam Integer id){
        Supplier supplier = supplierService.findById(id);
        ApiResponse<Supplier> apiResponse = ApiResponse.createResponse(supplier, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping
    public ResponseEntity<ApiResponse<Supplier>> createSupplier(@RequestBody SupplierCreate request){
        Supplier supplier = supplierService.save(request);
        ApiResponse<Supplier> apiResponse = ApiResponse.createResponse(supplier, "Thành công!", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PutMapping
    public ResponseEntity<ApiResponse<Supplier>> updateSupplier(@RequestParam Integer id,@RequestBody SupplierCreate request){
        Supplier supplier = supplierService.update(id, request);
        ApiResponse<Supplier> apiResponse = ApiResponse.createResponse(supplier, "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteSupplier(Integer id){
        supplierService.delete(id);
        ApiResponse<Void> apiResponse = ApiResponse.createResponse(null, "Xoá thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
