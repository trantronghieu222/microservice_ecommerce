package com.shop.cartservice.service.Impl;

import com.shop.cartservice.entity.Cart;
import com.shop.cartservice.repository.CartRepository;
import com.shop.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public List<Cart> findByUserId(Integer UserId) {
        return cartRepository.findByUserId(UserId);
    }

    @Override
    public Cart save(Cart request) {
        Optional<Cart> cart = cartRepository.findByUserIdAndProductId(request.getUserId(), request.getProductId());
        if (cart.isPresent()) {
            Cart existingCart = cart.get();
            existingCart.setProductQuantity(existingCart.getProductQuantity() + request.getProductQuantity());
            return cartRepository.save(existingCart);
        }
        else {
            return cartRepository.save(request);
        }
    }

    @Override
    public Cart update(Integer id, Cart request) {
        Cart cart = findById(id);
        cart.setProductQuantity(request.getProductQuantity());
        cart.setUserId(request.getUserId());
        cart.setProductId(request.getProductId());
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }
}
