package com.shop.productservice.service.impl;

import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.entity.Product;
import com.shop.productservice.entity.ProductType;
import com.shop.productservice.entity.Supplier;
import com.shop.productservice.exception.custom.ResourceNotFoundException;
import com.shop.productservice.repository.ProductRepository;
import com.shop.productservice.repository.ProductTypeRepository;
import com.shop.productservice.repository.SupplierRepository;
import com.shop.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(ProductCreate request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductInventory(request.getProductInventory());
        product.setProductWarranty(request.getProductWarranty());
        product.setProductImage(request.getProductImage());
        product.setProductSaleprice(request.getProductSaleprice());
        product.setProductInprice(request.getProductInprice());
        product.setProductDescription(request.getProductDescription());

        // Load SupplierModel từ database
        Optional<Supplier> supplierOptional = supplierRepository.findById(request.getSupplierId());
        if (supplierOptional.isPresent()) {
            product.setSupplier(supplierOptional.get());
        } else {
            throw new RuntimeException("Supplier not found with id: " + product.getSupplier());
        }

        // Load ProductTypeModel từ database
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(request.getTypeId());
        if (productTypeOptional.isPresent()) {
            product.setProductType(productTypeOptional.get());
        } else {
            throw new RuntimeException("Product type not found with id: " + product.getProductType());
        }

        productRepository.save(product);
        return product;
    }

    @Override
    public Product update(Integer id, ProductCreate request) {
        Product product = findById(id);
        product.setProductName(request.getProductName());
        product.setProductInventory(request.getProductInventory());
        product.setProductWarranty(request.getProductWarranty());
        product.setProductImage(request.getProductImage());
        product.setProductSaleprice(request.getProductSaleprice());
        product.setProductInprice(request.getProductInprice());
        product.setProductDescription(request.getProductDescription());

        // Load SupplierModel từ database
        Optional<Supplier> supplierOptional = supplierRepository.findById(request.getSupplierId());
        if (supplierOptional.isPresent()) {
            product.setSupplier(supplierOptional.get());
        } else {
            throw new RuntimeException("Supplier not found with id: " + product.getSupplier());
        }

        // Load ProductTypeModel từ database
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(request.getTypeId());
        if (productTypeOptional.isPresent()) {
            product.setProductType(productTypeOptional.get());
        } else {
            throw new RuntimeException("Product type not found with id: " + product.getProductType());
        }

        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Integer id) {

    }
}
