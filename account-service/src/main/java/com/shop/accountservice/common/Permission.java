package com.shop.accountservice.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Permission {
    ADMIN("Admin"),
    USER("User");

    private final String displayname;

    Permission(String displayname) {
        this.displayname = displayname;
    }

    @JsonValue
    public String getDisplayname() {
        return displayname;
    }
}
