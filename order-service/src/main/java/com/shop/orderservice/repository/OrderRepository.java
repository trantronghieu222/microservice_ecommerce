package com.shop.orderservice.repository;

import com.shop.orderservice.entity.Order;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId (Integer id);

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.orderDate BETWEEN :from AND :to")
    Double getTotalRevenue(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.orderDate = :date")
    Long getOrderCountByDate(@Param("date") LocalDate date);
}
