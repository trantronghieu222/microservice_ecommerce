package com.shop.productservice.exception;

public enum ErrorCode {
    PRODUCT_NOT_FOUND(404, "PRODUCT_NOT_FOUND", "Product not found."),
    SUPPLIER_NOT_FOUND(404, "SUPPLIER_NOT_FOUND", "Supplier not found."),
    PRODUCT_TYPE_NOT_FOUND(404, "PRODUCT_TYPE_NOT_FOUND", "Product type not found."),
    ;

    private final int statusCode;
    private final String errorCode;
    private final String message;

    ErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
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
