package com.shop.receivedservice.repository;

import com.shop.receivedservice.entity.ReceivedDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivedDetailRepository extends JpaRepository<ReceivedDetail, Integer> {
}
