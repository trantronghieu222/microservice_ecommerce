package com.shop.receivedservice.service;

import com.shop.receivedservice.entity.ReceivedDetail;

import java.util.List;

public interface ReceivedDetailService {
    List<ReceivedDetail> findAll();

    ReceivedDetail findById(Integer id);

    ReceivedDetail save(ReceivedDetail receivedDetail);

    ReceivedDetail update(Integer id, ReceivedDetail receivedDetail);

    void delete(Integer id);
}
