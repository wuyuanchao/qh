package com.chic.qh.controller.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String avatar;
    private String userId;
    private String access;

    public UserDTO() {
    }

    public UserDTO(String name, String avatar, String userId, String access) {
        this.name = name;
        this.avatar = avatar;
        this.userId = userId;
        this.access = access;
    }
}
