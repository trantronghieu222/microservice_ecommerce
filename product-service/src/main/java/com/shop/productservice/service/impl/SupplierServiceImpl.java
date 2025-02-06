package com.shop.productservice.service.impl;

import com.shop.productservice.dto.request.SupplierCreate;
import com.shop.productservice.entity.Supplier;
import com.shop.productservice.repository.SupplierRepository;
import com.shop.productservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Integer id) {
        return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public Supplier save(SupplierCreate request) {
        Supplier supplier = new Supplier();
        supplier.setSupllierName(request.getSupllierName());
        supplierRepository.save(supplier);
        return supplier;
    }

    @Override
    public Supplier update(Integer id, SupplierCreate request) {
        Supplier supplier = findById(id);
        supplier.setSupllierName(request.getSupllierName());
        supplierRepository.save(supplier);
        return supplier;
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        supplierRepository.deleteById(id);
    }
}
