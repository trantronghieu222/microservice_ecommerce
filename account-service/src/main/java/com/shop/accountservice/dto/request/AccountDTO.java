package com.shop.accountservice.dto.request;

import com.shop.accountservice.common.Permission;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

public class AccountDTO {
    @Column(name = "account_name", unique = true, nullable = false)
    private String username;

    @Column(name = "account_password", nullable = false)
    private String password;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_email")
    private String customerEmail;

    @JoinColumn(name = "permission", nullable = false)
    private Permission permission;

    // Getter & Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
