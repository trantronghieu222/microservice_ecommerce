package com.shop.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shop.orderservice.common.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

    // Getter Setter
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
