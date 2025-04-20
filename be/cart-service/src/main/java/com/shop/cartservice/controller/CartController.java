package com.shop.cartservice.controller;

import com.shop.cartservice.dto.request.UpdateQuantityDTO;
import com.shop.cartservice.dto.response.ApiResponse;
import com.shop.cartservice.entity.Cart;
import com.shop.cartservice.service.Impl.CartServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cart")
@Tag(name = "Cart Service")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Cart>>> getAllCart(){
        ApiResponse<List<Cart>> apiResponse = ApiResponse.createResponse(cartService.findAll(), "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{UserId}")
    public ResponseEntity<ApiResponse<List<Cart>>> getCartByUserId(@RequestParam Integer UserId){
        ApiResponse<List<Cart>> apiResponse = ApiResponse.createResponse(cartService.findByUserId(UserId), "Thành công!", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Cart>> createCart(@RequestBody Cart request){
        Cart cart = cartService.save(request);
        ApiResponse<Cart> apiResponse = ApiResponse.createResponse(cart, "Thêm thành công!", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Cart>> updateCart(@RequestParam Integer cartId, @RequestBody UpdateQuantityDTO newQuan){
        Cart cart = cartService.updateQuantity(cartId, newQuan);
        ApiResponse<Cart> apiResponse = ApiResponse.createResponse(cart, "Cập nhật thành công!", HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Object>> deleteCart(@RequestParam Integer cartId){
        cartService.delete(cartId);
        ApiResponse<Object> apiResponse = ApiResponse.createResponse(null, "Xoá thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
