package com.shop.productservice.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_inventory")
    private int productInventory;

    @Column(name = "product_warranty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate productWarranty;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "supplier_id")
    private Integer supplierId;

    @Column(name = "product_saleprice")
    private int productSaleprice;

    @Column(name = "product_inprice")
    private int productInprice;

//    @Column(name = "product_description")
//    private String productDescription;
    @Lob // Sử dụng @Lob để chỉ định kiểu dữ liệu lớn
    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "type_id")
    private Integer productTypeId;

    @Column(name = "is_deleted")
    private Boolean isDeleted ;

    // Getter Setter
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