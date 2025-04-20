package com.shop.orderservice.exception;

public enum ErrorCode {
    ORDER_NOT_FOUND(404, "ORDER_NOT_FOUND", "Order not found."),
    PRODUCT_OUT_OF_STOCK(400, "PRODUCT_OUT_OF_STOCK", "Not enough stock available.");
    ;

    private final int statusCode;
    private final String errorCode;
    private final String message;// Thêm timestamp

    ErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;// Gán timestamp khi tạo lỗi
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
