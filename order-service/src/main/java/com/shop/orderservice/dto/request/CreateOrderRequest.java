package com.shop.orderservice.dto.request;

import com.shop.orderservice.common.PaymentMethod;
import com.shop.orderservice.entity.OrderDetail;

import java.util.List;

public class CreateOrderRequest {
    private Integer customerId;
    private Double totalAmount;
    private PaymentMethod paymentMethod;
    private List<OrderDetail> orderDetails;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
