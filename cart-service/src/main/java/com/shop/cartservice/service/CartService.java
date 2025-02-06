package com.shop.cartservice.service;

import com.shop.cartservice.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();

    Cart findById(Integer id);

    List<Cart> findByUserId(Integer UserId);

    Cart save(Cart request);

    Cart update(Integer id, Cart request);

    void delete(Integer id);
}
