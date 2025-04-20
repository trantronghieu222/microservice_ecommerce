package com.shop.productservice.exception;

public enum ErrorCode {
    PRODUCT_NOT_FOUND(404, "PRODUCT_NOT_FOUND", "Sản phẩm không tồn tại."),
    SUPPLIER_NOT_FOUND(404, "SUPPLIER_NOT_FOUND", "Nhà cung cấp không tồn tại."),
    PRODUCT_TYPE_NOT_FOUND(404, "PRODUCT_TYPE_NOT_FOUND", "Loại sản phẩm không tồn tại."),
    INSUFFICIENT_PRODUCT_QUANTITY(400, "INSUFFICIENT_PRODUCT_QUANTITY", "Không đủ s lượng sản phẩm trong kho"),
    MAX_SIZE_ERROR(404, "MAX_SIZE_ERROR", "Max file size is 2MB"),
    TYPE_IMAGE_ERROR(404, "TYPE_IMAGE_ERROR", "Only jpg, png, gif, bmp files are allowed"),
    UPLOAD_FAIL(404, "UPLOAD_FAIL", "Failed to upload file")
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
