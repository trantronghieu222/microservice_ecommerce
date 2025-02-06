package com.shop.productservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "supplier_name")
    private String supllierName;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupllierName() {
        return supllierName;
    }

    public void setSupllierName(String supllierName) {
        this.supllierName = supllierName;
    }
}
