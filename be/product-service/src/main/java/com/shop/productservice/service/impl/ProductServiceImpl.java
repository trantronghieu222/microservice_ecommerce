package com.shop.productservice.service.impl;

import com.shop.productservice.dto.request.ProductCreate;
import com.shop.productservice.dto.response.CloudinaryResponse;
import com.shop.productservice.entity.Product;
import com.shop.productservice.exception.AppException;
import com.shop.productservice.exception.ErrorCode;
import com.shop.productservice.repository.ProductRepository;
import com.shop.productservice.service.ProductService;
import com.shop.productservice.service.ProductTypeService;
import com.shop.productservice.service.SupplierService;
import com.shop.productservice.util.FileUploadUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Value("${file.upload-dir}")
    private String uploadDir;


    @Override
    public List<Product> findAll() {
        return productRepository.findByAndIsDeletedFalse();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findByProductIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    @Override
    public Page<Product> searchPagingProduct(String keyword, Integer pageIndex, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize); // `pageIndex` bắt đầu từ 1
        return productRepository.findByProductNameContainingIgnoreCaseAndIsDeletedFalse(keyword, pageable);
    }

    @Override
    public Product save(ProductCreate request) {
        // Kiểm tra product type
        productTypeService.findById(request.getProductTypeId());
        // Kiểm tra supplier
        supplierService.findById(request.getSupplierId());
        // create
        Product product = modelMapper.map(request, Product.class);
        product.setDeleted(false);
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, ProductCreate request) {
        // Kiểm tra product type
        productTypeService.findById(request.getProductTypeId());
        // Kiểm tra supplier
        supplierService.findById(request.getSupplierId());
        //
        Product product = findById(id);
        modelMapper.map(request, product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product request) {
        // Kiểm tra product type
        productTypeService.findById(request.getProductTypeId());
        // Kiểm tra supplier
        supplierService.findById(request.getSupplierId());
        //
        Product product = findById(request.getProductId());
        modelMapper.map(request, product);
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        product.setDeleted(true);
        productRepository.save(product);
    }

    @Override
    public Product uploadProductImage(Integer id, MultipartFile file) {
        Product product = findById(id);

        try {
            // Định nghĩa thư mục lưu ảnh trong thư mục gốc của dự án
            String uploadDir = System.getProperty("user.dir") + "/product-service/src/main/resources/static/";

            // Tạo tên file mới (tránh trùng lặp)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String filePath = uploadDir + fileName;

            // Lưu file vào thư mục
            file.transferTo(new File(filePath));

            // Cập nhật đường dẫn ảnh vào database
            product.setProductImage(fileName);

            return productRepository.save(product);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload file: " + e.getMessage());
        }
    }

    @Override
    public Product uploadImage(Integer id, MultipartFile file) {
        Product product = findById(id);

        FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);

        String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
        CloudinaryResponse response = cloudinaryService.uploadFile(file, fileName);
        product.setProductImage(response.getUrl());
//        product.setCloudinaryImageId(response.getPublicId());
        return productRepository.save(product);
    }
}