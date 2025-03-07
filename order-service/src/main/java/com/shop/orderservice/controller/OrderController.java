package com.shop.orderservice.controller;

import com.shop.orderservice.dto.request.CreateOrderRequest;
import com.shop.orderservice.dto.request.UpdateStatusRequest;
import com.shop.orderservice.dto.response.ApiResponse;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrder(){
        List<Order> orders = orderService.findAll();
        ApiResponse<List<Order>> apiResponse = ApiResponse.createResponse(orders, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrderById (@PathVariable Integer id) {
        Order order = orderService.findById(id);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("get-by-customer/{id}")
    public ResponseEntity<ApiResponse<List<Order>>> getOrderByCustomerId (@RequestParam Integer id) {
        List<Order> orders = orderService.findByCustomerId(id);
        ApiResponse<List<Order>> apiResponse = ApiResponse.createResponse(orders, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Order> saveOrder(@RequestParam Integer UserId, @RequestBody List<OrderDetail> orderDetails) {
//        return ResponseEntity.ok(orderService.save(UserId, orderDetails));
//    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        Order order = orderService.createOrder(createOrderRequest);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Dặt hàng thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<Order>> updateStatus(
            @RequestParam Integer OrderId,
            @RequestBody UpdateStatusRequest updateStatusRequest)
    {
        Order order = orderService.updateStatus(OrderId, updateStatusRequest);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Cập nhật thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(null, "Xoá đơn hàng thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}