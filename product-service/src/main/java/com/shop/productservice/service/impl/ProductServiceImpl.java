package com.shop.productservice.service.impl;

import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.entity.Product;
import com.shop.productservice.entity.ProductType;
import com.shop.productservice.entity.Supplier;
import com.shop.productservice.exception.AppException;
import com.shop.productservice.exception.ErrorCode;
import com.shop.productservice.repository.ProductRepository;
import com.shop.productservice.repository.ProductTypeRepository;
import com.shop.productservice.repository.SupplierRepository;
import com.shop.productservice.service.ProductService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    @Override
    public Product save(ProductCreate request) {
        Product product = modelMapper.map(request, Product.class);

        // Load SupplierModel từ database
        Optional<Supplier> supplierOptional = supplierRepository.findById(request.getSupplierId());
        if (supplierOptional.isPresent()) {
            product.setSupplier(supplierOptional.get());
        } else {
            throw new AppException(ErrorCode.SUPPLIER_NOT_FOUND);
        }

        // Load ProductTypeModel từ database
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(request.getTypeId());
        if (productTypeOptional.isPresent()) {
            product.setProductType(productTypeOptional.get());
        } else {
            throw new AppException(ErrorCode.PRODUCT_TYPE_NOT_FOUND);
        }

        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, ProductCreate request) {
        Product product = findById(id);
        modelMapper.map(request, product);

        // Load SupplierModel từ database
        Optional<Supplier> supplierOptional = supplierRepository.findById(request.getSupplierId());
        if (supplierOptional.isPresent()) {
            product.setSupplier(supplierOptional.get());
        } else {
            throw new AppException(ErrorCode.SUPPLIER_NOT_FOUND);
        }

        // Load ProductTypeModel từ database
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(request.getTypeId());
        if (productTypeOptional.isPresent()) {
            product.setProductType(productTypeOptional.get());
        } else {
            throw new AppException(ErrorCode.PRODUCT_TYPE_NOT_FOUND);
        }

        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        product.setDeleted(true);
    }
}
