package com.shop.productservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer ProductTypeId;

    @Column(name = "type_name")
    private String productTypeName;

    public Integer getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        ProductTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}