package com.shop.receivedservice.service.impl;

import com.shop.receivedservice.Client.AccountClient;
import com.shop.receivedservice.Client.ProductClient;
import com.shop.receivedservice.dto.request.ReceivedCreateRequest;
import com.shop.receivedservice.entity.Received;
import com.shop.receivedservice.entity.ReceivedDetail;
import com.shop.receivedservice.exception.AppException;
import com.shop.receivedservice.exception.ErrorCode;
import com.shop.receivedservice.repository.ReceivedRepository;
import com.shop.receivedservice.service.ReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReceivedServiceImpl implements ReceivedService {
    @Autowired
    private ReceivedRepository receivedRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public List<Received> findAll() {
        return receivedRepository.findAll();
    }

    @Override
    public Received findById(Integer id) {
        return receivedRepository.findById(id).
                orElseThrow(() -> new AppException(ErrorCode.RECEIVED_NOT_FOUND));
    }

        @Override
    public Received create(ReceivedCreateRequest receivedCreateRequest) {
        Received received = new Received();
        received.setUserId(receivedCreateRequest.getUserId());
        received.setReceivedDate(LocalDate.now());

        double totalMoney = 0.0;

        for (ReceivedDetail receivedDetail: receivedCreateRequest.getReceivedDetails()){
            totalMoney += receivedDetail.getProductQuantity() * receivedDetail.getProductInprice();
        }

        received.setReceivedMoney(totalMoney);

        receivedCreateRequest.getReceivedDetails().forEach(receivedDetail -> receivedDetail.setReceived(received));
        received.setReceivedDetails(receivedCreateRequest.getReceivedDetails());

        return receivedRepository.save(received);
    }


//    @Override
//    public Received create(ReceivedCreateRequest receivedCreateRequest) {
//        accountClient.getAccountById(receivedCreateRequest.getUserId());
//
//        Received received = new Received();
//        received.setUserId(receivedCreateRequest.getUserId());
//        received.setReceivedDate(new Date());
//
//        double totalMoney = 0.0;
//
//        for (ReceivedDetail receivedDetail: receivedCreateRequest.getReceivedDetails()){
//            productClient.getProductById(receivedDetail.getProductId());
//
//            totalMoney += receivedDetail.getProductQuantity() * receivedDetail.getProductInprice();
//        }
//
//        received.setReceivedMoney(totalMoney);
//
//        receivedCreateRequest.getReceivedDetails().forEach(receivedDetail -> receivedDetail.setReceived(received));
//        received.setReceivedDetails(receivedCreateRequest.getReceivedDetails());
//
//        return receivedRepository.save(received);
//    }

    @Override
    public void delete(Integer id) {
        receivedRepository.deleteById(id);
    }
}
