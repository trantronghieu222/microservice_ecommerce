package com.shop.accountservice.exception;

import java.time.OffsetDateTime;

public enum ErrorCode {
    USER_NOT_FOUND(404, "USER_NOT_FOUND", "User not found."),
    USERNAME_ALREADY_EXISTS(409, "USERNAME_ALREADY_EXISTS", "The username already exists in the system."),
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
