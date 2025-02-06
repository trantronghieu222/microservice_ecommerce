package com.shop.receivedservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "ReceivedDetail")
public class ReceivedDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receivedDetail_id")
    @Schema(hidden = true)
    private Integer receivedDetailId;

    @ManyToOne
    @JoinColumn(name = "received_id", nullable = false)
    @JsonBackReference
    @Schema(hidden = true)
    private Received received;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "product_inprice")
    private Double productInprice;

    // Getter & Setter
    public Integer getReceivedDetailId() {
        return receivedDetailId;
    }

    public void setReceivedDetailId(Integer receivedDetailId) {
        this.receivedDetailId = receivedDetailId;
    }

    public Received getReceived() {
        return received;
    }

    public void setReceived(Received received) {
        this.received = received;
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

    public Double getProductInprice() {
        return productInprice;
    }

    public void setProductInprice(Double productInprice) {
        this.productInprice = productInprice;
    }
}
