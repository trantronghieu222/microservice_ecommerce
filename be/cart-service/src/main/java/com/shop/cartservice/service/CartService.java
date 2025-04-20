package com.shop.cartservice.service;

import com.shop.cartservice.dto.request.UpdateQuantityDTO;
import com.shop.cartservice.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();

    Cart findById(Integer id);

    List<Cart> findByUserId(Integer UserId);

    Cart save(Cart request);

    Cart updateQuantity(Integer id, UpdateQuantityDTO request);

    void delete(Integer id);
}
