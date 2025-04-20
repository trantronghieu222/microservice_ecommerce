package com.shop.productservice.service;

import com.shop.productservice.dto.request.ProductTypeCreate;
import com.shop.productservice.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAll();

    ProductType findById(Integer id);

    ProductType save(ProductTypeCreate request);

    ProductType update(Integer id, ProductTypeCreate request);

    void delete(Integer id);
}
