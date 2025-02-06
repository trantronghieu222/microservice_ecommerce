package com.shop.receivedservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ReceivedRepository")
public class Received {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "received_id")
    private Integer receivedId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "received_date")
    private Date receivedDate;

    @Column(name = "received_money")
    private Double receivedMoney;

    @OneToMany(mappedBy = "received", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ReceivedDetail> receivedDetails;

    // Getter & Setter
    public Integer getReceivedId() {
        return receivedId;
    }

    public void setReceivedId(Integer receivedId) {
        this.receivedId = receivedId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Double getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(Double receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public List<ReceivedDetail> getReceivedDetails() {
        return receivedDetails;
    }

    public void setReceivedDetails(List<ReceivedDetail> receivedDetails) {
        this.receivedDetails = receivedDetails;
    }
}
