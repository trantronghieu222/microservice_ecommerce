package com.shop.cartservice.service.Impl;

import com.shop.cartservice.client.AccountClient;
import com.shop.cartservice.client.ProductClient;
import com.shop.cartservice.dto.request.Product;
import com.shop.cartservice.dto.request.UpdateQuantityDTO;
import com.shop.cartservice.entity.Cart;
import com.shop.cartservice.exception.custom.ResourceNotFoundException;
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

    @Autowired
    private ProductClient productClient;

    @Autowired
    private AccountClient accountClient;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    @Override
    public List<Cart> findByUserId(Integer UserId) {
        return cartRepository.findByUserId(UserId);
    }

    @Override
    public Cart save(Cart request) {
        accountClient.getAccountById(request.getUserId());
        productClient.getProductById(request.getProductId());

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
    public Cart updateQuantity(Integer id, UpdateQuantityDTO request) {
        Cart cart = findById(id);
        cart.setProductQuantity(request.getProductQuantity());
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }
}
