package com.shop.orderservice.service.impl;

import com.shop.orderservice.common.OrderStatus;
import com.shop.orderservice.dto.request.UpdateStatusRequest;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.entity.OrderDetail;
import com.shop.orderservice.repository.OrderRepository;
import com.shop.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order save(Integer id, List<OrderDetail> orderDetails) {
        Order order = new Order();
        order.setCustomerId(id);
        order.setOrderDate(new Date());
        order.setOrderStatus(OrderStatus.PENDING);

        double totalAmount = orderDetails.stream()
                .mapToDouble(detail -> detail.getProductQuantity() * detail.getProductPrice())
                .sum();
        order.setTotalAmount(totalAmount);

        orderDetails.forEach(detail -> detail.setOrders(order));
        order.setOrderDetails(orderDetails);

        return orderRepository.save(order);
    }

    @Override
    public Order updateStatus(Integer id, UpdateStatusRequest request) {
        Order order = findById(id);
        order.setOrderStatus(request.getOrderStatus());
        return orderRepository.save(order);
    }

}
