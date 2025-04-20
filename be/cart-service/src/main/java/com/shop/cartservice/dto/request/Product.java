package com.shop.cartservice.dto.request;

import java.util.Date;

public class Product {
    private Integer productId;
    private String productName;
    private int productInventory;
    private Date productWarranty;
    private String productImage;
    private Supplier supplier;
    private int productSaleprice;
    private int productInprice;
    private String productDescription;
    private ProductType productType;
    private Boolean isDeleted;

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

    public Date getProductWarranty() {
        return productWarranty;
    }

    public void setProductWarranty(Date productWarranty) {
        this.productWarranty = productWarranty;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
