package com.shop.orderservice.controller;

import com.shop.orderservice.dto.request.CreateOrderRequest;
import com.shop.orderservice.dto.request.UpdateStatusRequest;
import com.shop.orderservice.dto.response.ApiResponse;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.entity.OrderDetail;
import com.shop.orderservice.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orders")
@Tag(name = "Orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestParam Integer UserId, @RequestBody List<OrderDetail> orderDetails) {
        return ResponseEntity.ok(orderService.save(UserId, orderDetails));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        Order order = orderService.createOrder(createOrderRequest);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Dặt hàng thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Order> updateStatus(@RequestParam Integer OrderId, @RequestBody UpdateStatusRequest updateStatusRequest){
        return ResponseEntity.ok(orderService.updateStatus(OrderId, updateStatusRequest));
    }
}
