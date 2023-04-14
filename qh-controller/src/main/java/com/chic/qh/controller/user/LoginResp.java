package com.chic.qh.controller.user;

import lombok.Data;

@Data
public class LoginResp {
    private String status;
    private String type;
    private String currentAuthority;
}
