package com.shop.receivedservice.dto.request;

import com.shop.receivedservice.entity.ReceivedDetail;

import java.util.List;

public class ReceivedCreateRequest {
    private Integer userId;
    private List<ReceivedDetail> receivedDetails;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<ReceivedDetail> getReceivedDetails() {
        return receivedDetails;
    }

    public void setReceivedDetails(List<ReceivedDetail> receivedDetails) {
        this.receivedDetails = receivedDetails;
    }
}
