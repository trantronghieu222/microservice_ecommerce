package com.shop.accountservice.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN("Admin"),
    USER("User");

    private final String displayname;

    Role(String displayname) {
        this.displayname = displayname;
    }

    @JsonValue
    public String getDisplayname() {
        return displayname;
    }
}
