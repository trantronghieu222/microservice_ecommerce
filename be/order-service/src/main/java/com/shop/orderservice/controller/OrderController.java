package com.shop.orderservice.controller;

import com.shop.orderservice.dto.request.CreateOrderRequest;
import com.shop.orderservice.dto.request.UpdateStatusRequest;
import com.shop.orderservice.dto.response.ApiResponse;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @SecurityRequirement(name = "BearerAuth")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrder(){
        List<Order> orders = orderService.findAll();
        ApiResponse<List<Order>> apiResponse = ApiResponse.createResponse(orders, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrderById (@PathVariable Integer id) {
        Order order = orderService.findById(id);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @GetMapping("get-by-customer/{id}")
    public ResponseEntity<ApiResponse<List<Order>>> getOrderByCustomerId (@PathVariable Integer id) {
        List<Order> orders = orderService.findByCustomerId(id);
        ApiResponse<List<Order>> apiResponse = ApiResponse.createResponse(orders, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Order> saveOrder(@RequestParam Integer UserId, @RequestBody List<OrderDetail> orderDetails) {
//        return ResponseEntity.ok(orderService.save(UserId, orderDetails));
//    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        Order order = orderService.createOrder(createOrderRequest);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Dặt hàng thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping("/CircuitBreaker")
    public ResponseEntity<ApiResponse<Order>> createOrderCircuitBreaker(@RequestBody CreateOrderRequest createOrderRequest){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Order order = orderService.createOrder(createOrderRequest);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Dặt hàng thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "BearerAuth")
    @PutMapping
    public ResponseEntity<ApiResponse<Order>> updateStatus(
            @RequestParam Integer OrderId,
            @RequestBody UpdateStatusRequest updateStatusRequest)
    {
        Order order = orderService.updateStatus(OrderId, updateStatusRequest);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(order, "Cập nhật thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        ApiResponse<Order> apiResponse = ApiResponse.createResponse(null, "Xoá đơn hàng thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @SecurityRequirement(name = "BearerAuth")
    @GetMapping("/total-revenue")
    public ResponseEntity<Double> getTotalRevenue(
            @RequestParam("from") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate from,
            @RequestParam("to") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate to)
    {
        Double revenue = orderService.getTotalRevenue(from, to);
        return ResponseEntity.ok(revenue);
    }

    @SecurityRequirement(name = "BearerAuth")
    @GetMapping("/count")
    public ResponseEntity<Long> getOrderCountByDate(
            @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date)
    {
        Long count = orderService.getOrderCountByDate(date);
        return ResponseEntity.ok(count);
    }


}