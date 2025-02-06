package com.shop.productservice.controller;

import com.shop.productservice.dto.request.SupplierCreate;
import com.shop.productservice.entity.Supplier;
import com.shop.productservice.service.impl.SupplierServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Supplier")
@Tag(name = "Supplier")
public class SupplierController {
    @Autowired
    private SupplierServiceImpl supplierService;

    @GetMapping
    public List<Supplier> getAllSupplier(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@RequestParam Integer id){
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody SupplierCreate request){
        Supplier supplier = supplierService.save(request);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping
    public ResponseEntity<Supplier> updateSupplier(@RequestParam Integer id,@RequestBody SupplierCreate request){
        Supplier supplier = supplierService.update(id, request);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSupplier(Integer id){
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
