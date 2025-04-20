package com.shop.receivedservice.dto.response;

import java.time.OffsetDateTime;

public class ApiResponse<T> {
    private int status;
    private String message;
    private T content;
    private OffsetDateTime timestamp;

    public ApiResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static <T> ApiResponse<T> createResponse(T content, String message, int statusCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(statusCode);
        response.setMessage(message);
        response.setContent(content);
        response.setTimestamp(OffsetDateTime.now());
        return response;
    }
}
