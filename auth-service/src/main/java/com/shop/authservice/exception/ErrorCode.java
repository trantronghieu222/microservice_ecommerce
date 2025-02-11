package com.shop.authservice.exception;

public enum ErrorCode {
    USER_NOT_FOUND(404, "USER_NOT_FOUND", "Tài khoản không chính xác!"),
    USERNAME_ALREADY_EXISTS(409, "USERNAME_ALREADY_EXISTS", "Tài khoản đã tồn tại!"),
    INVALID_CREDENTIALS(401, "INVALID_CREDENTIALS", "Mật khẩu không chính xác!"),
    JWT_TOKEN_CREATION_FAILED(500, "JWT_TOKEN_CREATION_FAILED", "Lỗi khi tạo JWT token!"),
    INVALID_JWT_TOKEN(401, "INVALID_JWT_TOKEN", "Token JWT không hợp lệ!"),
    JWT_TOKEN_EXPIRED(401, "JWT_TOKEN_EXPIRED", "Token đã hết hạn!"),
    UNAUTHORIZED_ACCESS(403, "UNAUTHORIZED_ACCESS", "Bạn không có quyền truy cập!"),
    BAD_REQUEST(400, "BAD_REQUEST", "Yêu cầu không hợp lệ!"),
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
