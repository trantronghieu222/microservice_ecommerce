package com.shop.productservice.entity;
import jakarta.persistence.*;
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
    private Date productWarranty;

    @Column(name = "product_image")
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "product_saleprice")
    private int productSaleprice;

    @Column(name = "product_inprice")
    private int productInprice;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType productType;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

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
