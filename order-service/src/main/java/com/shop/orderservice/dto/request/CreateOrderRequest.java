package com.shop.orderservice.dto.request;

import com.shop.orderservice.entity.OrderDetail;

import java.util.List;

public class CreateOrderRequest {
    private Integer customerId;
    private List<OrderDetail> orderDetails;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
