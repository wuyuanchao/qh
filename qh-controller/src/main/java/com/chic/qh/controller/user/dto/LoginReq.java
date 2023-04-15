package com.chic.qh.controller.user.dto;

import lombok.Data;

@Data
public class LoginReq {
    private String username;
    private String password;
    private String type;

    public LoginReq() {
    }

    public LoginReq(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }
}
