package com.shop.orderservice.service.impl;

import com.shop.orderservice.client.AccountClient;
import com.shop.orderservice.client.ProductClient;
import com.shop.orderservice.common.OrderStatus;
import com.shop.orderservice.dto.request.CreateOrderRequest;
import com.shop.orderservice.dto.request.UpdateStatusRequest;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.entity.OrderDetail;
import com.shop.orderservice.exception.AppException;
import com.shop.orderservice.exception.ErrorCode;
import com.shop.orderservice.repository.OrderRepository;
import com.shop.orderservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
    }

    @Override
    public List<Order> findByCustomerId(Integer id) {
        return orderRepository.findByCustomerId(id);
    }

    @Override
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        accountClient.getAccountById(createOrderRequest.getCustomerId());

        Order order = new Order();
        order.setCustomerId(createOrderRequest.getCustomerId());
        order.setOrderDate(LocalDate.now());
        order.setPaymentMethod(createOrderRequest.getPaymentMethod());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setTotalAmount(createOrderRequest.getTotalAmount());

        for (OrderDetail orderDetail: createOrderRequest.getOrderDetails()){
            boolean isAvailable = productClient.checkStock(orderDetail.getProductId(), orderDetail.getProductQuantity());
            if (isAvailable) {
                productClient.getProductById(orderDetail.getProductId());
            }
            else {
                throw new AppException(ErrorCode.PRODUCT_OUT_OF_STOCK);
            }
        }

        createOrderRequest.getOrderDetails().forEach(orderDetail -> orderDetail.setOrders(order));
        order.setOrderDetails(createOrderRequest.getOrderDetails());

        return orderRepository.save(order);
    }

    @Override
    public Order updateStatus(Integer id, UpdateStatusRequest request) {
        Order order = findById(id);
        order.setOrderStatus(request.getOrderStatus());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        findById(id);
        orderRepository.deleteById(id);
    }

    @Override
    public Double getTotalRevenue(LocalDate from, LocalDate to) {
        Double revenue = orderRepository.getTotalRevenue(from, to);
        return (revenue != null) ? revenue : 0.0;
    }

    @Override
    public Long getOrderCountByDate(LocalDate date) {
        return orderRepository.getOrderCountByDate(date);
    }
}
