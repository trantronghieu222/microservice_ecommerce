package com.shop.receivedservice.service;

import com.shop.receivedservice.entity.Received;
import com.shop.receivedservice.entity.ReceivedDetail;

import java.util.List;

public interface ReceivedService {
    List<Received> findAll();

    Received findById(Integer id);

    Received save(Integer userId, List<ReceivedDetail> receivedDetails);

    void delete(Integer id);
}
