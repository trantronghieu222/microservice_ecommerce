package com.shop.receivedservice.service.impl;

import com.shop.receivedservice.entity.ReceivedDetail;
import com.shop.receivedservice.repository.ReceivedDetailRepository;
import com.shop.receivedservice.repository.ReceivedRepository;
import com.shop.receivedservice.service.ReceivedDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceivedDetailServiceImpl implements ReceivedDetailService {
    @Autowired
    private ReceivedDetailRepository receivedDetailRepository;


    @Override
    public List<ReceivedDetail> findAll() {
        return receivedDetailRepository.findAll();
    }

    @Override
    public ReceivedDetail findById(Integer id) {
        return receivedDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Received Detail not found"));
    }

    @Override
    public ReceivedDetail save(ReceivedDetail receivedDetail) {
        return receivedDetailRepository.save(receivedDetail);
    }

    @Override
    public ReceivedDetail update(Integer id, ReceivedDetail receivedDetail) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
