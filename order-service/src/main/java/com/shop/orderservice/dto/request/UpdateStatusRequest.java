package com.shop.orderservice.dto.request;

import com.shop.orderservice.common.OrderStatus;

public class UpdateStatusRequest {
    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
