package com.shop.cartservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.cartservice.dto.response.ApiResponse;
import com.shop.cartservice.exception.custom.InvalidInputException;
import com.shop.cartservice.exception.custom.ResourceNotFoundException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse<Object> response = ApiResponse.createResponse(null, ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ApiResponse<Object>> handleInvalidInputException(InvalidInputException ex) {
        ApiResponse<Object> response = ApiResponse.createResponse(null, ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ApiResponse<Object>> handleFeignException(FeignException ex) {
        // 1. Trích xuất thông tin lỗi từ response của Product Service
        String errorMessage = "Lỗi từ Product Service";
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        Object content = null;
        try {
            // Sử dụng ObjectMapper để parse response body
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = ex.contentUTF8();
            if (responseBody != null && !responseBody.isEmpty()) {
                Map<String, Object> errorResponse = mapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorResponse.get("message");
                statusCode = (Integer) errorResponse.get("status");
                content = errorResponse.get("content");
            }
        } catch (IOException e) {
            // Xử lý lỗi parse JSON (nếu cần)
            e.printStackTrace();
        }
        // 2. Tạo ApiResponse trong Order Service
        ApiResponse<Object> response = ApiResponse.createResponse(
                content,
                errorMessage,
                statusCode
        );
        // 3. Trả về response
        return new ResponseEntity<>(response, HttpStatus.valueOf(statusCode));
    }
}
