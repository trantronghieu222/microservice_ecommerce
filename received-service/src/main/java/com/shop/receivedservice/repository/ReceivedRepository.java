package com.shop.receivedservice.repository;

import com.shop.receivedservice.entity.Received;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivedRepository extends JpaRepository<Received, Integer> {
}
