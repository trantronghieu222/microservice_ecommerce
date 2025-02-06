package com.shop.productservice.dto.response;

import java.util.List;

public class SupplierListResponse {
    private List<SupplierResponse> suppliers;

    public List<SupplierResponse> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierResponse> suppliers) {
        this.suppliers = suppliers;
    }
}
