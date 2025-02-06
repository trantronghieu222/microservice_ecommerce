package com.shop.receivedservice.service.impl;

import com.shop.receivedservice.entity.Received;
import com.shop.receivedservice.entity.ReceivedDetail;
import com.shop.receivedservice.repository.ReceivedRepository;
import com.shop.receivedservice.service.ReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReceivedServiceImpl implements ReceivedService {
    @Autowired
    private ReceivedRepository receivedRepository;

    @Override
    public List<Received> findAll() {
        return receivedRepository.findAll();
    }

    @Override
    public Received findById(Integer id) {
        return receivedRepository.findById(id).orElseThrow(() -> new RuntimeException("Received not found"));
    }

    @Override
    public Received save(Integer userId, List<ReceivedDetail> receivedDetails) {
        Received received = new Received();
        received.setReceivedDate(new Date());
        received.setUserId(userId);

        double receivedMoney = receivedDetails.stream()
                .mapToDouble(detail -> detail.getProductInprice() * detail.getProductQuantity())
                .sum();
        received.setReceivedMoney(receivedMoney);

        receivedDetails.forEach(detail -> detail.setReceived(received));
        received.setReceivedDetails(receivedDetails);

        return receivedRepository.save(received);
    }

    @Override
    public void delete(Integer id) {
        receivedRepository.deleteById(id);
    }
}
