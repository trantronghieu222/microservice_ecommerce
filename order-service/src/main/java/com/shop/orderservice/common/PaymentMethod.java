package com.shop.orderservice.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {
    CASH_ON_DELIVERY("Cash_On_Delivery"),
    CREDIT_CARD("Credit_Card"),
    PAYPAL("PayPal"),
    VNPAY("VNPay"),
    MOMO("MoMo");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}