package com.chic.qh.controller.user;

import lombok.Data;

@Data
public class User {
    private String name;
    private String avatar;
    private String userId;

    public User() {
    }

    public User(String name, String avatar, String userId) {
        this.name = name;
        this.avatar = avatar;
        this.userId = userId;
    }
}
