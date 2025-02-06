package com.shop.productservice.dto.response;

import java.util.List;

public class ProductListResponse {
    private List<ProductResponse> products;

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
