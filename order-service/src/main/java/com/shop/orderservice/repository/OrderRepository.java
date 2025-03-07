package com.shop.orderservice.repository;

import com.shop.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId (Integer id);
}
