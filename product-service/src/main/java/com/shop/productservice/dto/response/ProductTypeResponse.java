package com.shop.productservice.dto.response;

public class ProductTypeResponse {
    private Integer supplierId;
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
