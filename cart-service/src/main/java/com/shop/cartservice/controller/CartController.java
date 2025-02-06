package com.shop.cartservice.controller;

import com.shop.cartservice.entity.Cart;
import com.shop.cartservice.service.Impl.CartServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Cart> getAllCart(){
        return cartService.findAll();
    }

    @GetMapping("/{UserId}")
    public List<Cart> getCartByUserId(@RequestParam Integer UserId){
        return cartService.findByUserId(UserId);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.save(cart));
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(@RequestParam Integer id, @RequestBody Cart cart){
        return ResponseEntity.ok(cartService.update(id, cart));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCart(@RequestParam Integer id){
        cartService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
