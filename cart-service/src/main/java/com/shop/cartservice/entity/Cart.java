package com.shop.cartservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @Schema(hidden = true)
    private Integer cartId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    // Getter & Setter
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
