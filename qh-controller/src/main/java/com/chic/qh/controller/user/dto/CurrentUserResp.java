package com.chic.qh.controller.user.dto;

import lombok.Data;

@Data
public class CurrentUserResp {
    private boolean success;
    private Object data;

    public CurrentUserResp() {
    }

    public CurrentUserResp(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

}
