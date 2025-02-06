package com.shop.productservice.service;

import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    Product save(ProductCreate request);

    Product update(Integer id, ProductCreate request);

    void delete(Integer id);
}
