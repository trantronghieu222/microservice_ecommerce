package com.shop.productservice.service.impl;

import com.shop.productservice.dto.request.ProductTypeCreate;
import com.shop.productservice.entity.ProductType;
import com.shop.productservice.exception.custom.ResourceNotFoundException;
import com.shop.productservice.repository.ProductTypeRepository;
import com.shop.productservice.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;


    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Product type not found!"));
    }

    @Override
    public ProductType save(ProductTypeCreate request) {
        ProductType productType = new ProductType();
        productType.setTypeName(request.getTypeName());
        productTypeRepository.save(productType);
        return productType;
    }

    @Override
    public ProductType update(Integer id, ProductTypeCreate request) {
        ProductType productType = findById(id);
        productType.setTypeName(request.getTypeName());
        productTypeRepository.save(productType);
        return productType;
    }

    @Override
    public void delete(Integer id) {
        productTypeRepository.deleteById(id);
    }
}
