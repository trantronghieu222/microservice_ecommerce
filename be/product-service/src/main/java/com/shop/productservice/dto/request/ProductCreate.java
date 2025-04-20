package com.shop.productservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class ProductCreate {
    private String productName;
    private Integer productInventory;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate productWarranty;
    private String productImage;
    private Integer productSaleprice;
    private Integer productInprice;
    private String productDescription;
    private Integer supplierId;
    private Integer productTypeId;
//    private boolean deleted;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(Integer productInventory) {
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

    public Integer getProductSaleprice() {
        return productSaleprice;
    }

    public void setProductSaleprice(Integer productSaleprice) {
        this.productSaleprice = productSaleprice;
    }

    public Integer getProductInprice() {
        return productInprice;
    }

    public void setProductInprice(Integer productInprice) {
        this.productInprice = productInprice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }
}