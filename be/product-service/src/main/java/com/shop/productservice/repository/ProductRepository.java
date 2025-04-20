package com.shop.productservice.repository;

import com.shop.productservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByProductNameContainingIgnoreCaseAndIsDeletedFalse(String productName, Pageable pageable);

    List<Product> findByAndIsDeletedFalse();

    Optional<Product> findByProductIdAndIsDeletedFalse(Integer id);
}
