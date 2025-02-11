package com.shop.orderservice.service;

import com.shop.orderservice.dto.request.CreateOrderRequest;
import com.shop.orderservice.dto.request.UpdateStatusRequest;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Integer id);

    Order save(Integer id, List<OrderDetail> orderDetails);

    Order createOrder(CreateOrderRequest createOrderRequest);

    Order updateStatus(Integer id, UpdateStatusRequest request);
}
