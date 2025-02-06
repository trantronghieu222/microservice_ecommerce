package com.shop.productservice.dto.response;

import java.util.Date;

public class ProductResponse {
    private Integer productId;
    private String productName;
    private Integer productInventory;
    private Date productWarranty;
    private String productImage;
    private Integer productSaleprice;
    private Integer productInprice;
    private String productDescription;
    private Integer supplierId;
    private Integer typeId;
    private boolean deleted;

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

    public Integer getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(Integer productInventory) {
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
