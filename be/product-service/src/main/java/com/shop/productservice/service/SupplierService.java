package com.shop.productservice.service;

import com.shop.productservice.dto.request.SupplierCreate;
import com.shop.productservice.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();

    Supplier findById(Integer id);

    Supplier save(SupplierCreate request);

    Supplier update(Integer id, SupplierCreate request);

    void delete(Integer id);
}
