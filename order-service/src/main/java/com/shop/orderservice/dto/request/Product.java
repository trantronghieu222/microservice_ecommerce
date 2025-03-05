package com.shop.orderservice.dto.request;

import java.time.LocalDate;
import java.util.Date;

public class Product {
    private Integer productId;
    private String productName;
    private int productInventory;
    private LocalDate productWarranty;
    private String productImage;
    private Integer supplierId;
    private int productSaleprice;
    private int productInprice;
    private String productDescription;
    private Integer productTypeId;
    private Boolean isDeleted ;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    public LocalDate getProductWarranty() {
        return productWarranty;
    }

    public void setProductWarranty(LocalDate productWarranty) {
        this.productWarranty = productWarranty;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public int getProductSaleprice() {
        return productSaleprice;
    }

    public void setProductSaleprice(int productSaleprice) {
        this.productSaleprice = productSaleprice;
    }

    public int getProductInprice() {
        return productInprice;
    }

    public void setProductInprice(int productInprice) {
        this.productInprice = productInprice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
