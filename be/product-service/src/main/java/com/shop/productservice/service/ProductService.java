package com.shop.productservice.service;

import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    Page<Product> searchPagingProduct(String keyword, Integer pageIndex, Integer pageSize);

    Product save(ProductCreate request);

    Product update(Integer id, ProductCreate request);

    Product updateProduct(Product request);

    void delete(Integer id);

    Product uploadProductImage(Integer id, MultipartFile file);

    Product uploadImage(Integer id, MultipartFile file);
}
