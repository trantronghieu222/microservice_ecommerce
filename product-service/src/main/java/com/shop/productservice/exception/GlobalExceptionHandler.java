package com.shop.productservice.exception;

import com.shop.productservice.dto.response.ApiResponse;
import com.shop.productservice.exception.custom.InvalidInputException;
import com.shop.productservice.exception.custom.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
}
