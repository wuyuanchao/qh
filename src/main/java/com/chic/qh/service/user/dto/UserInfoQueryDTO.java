package com.chic.qh.service.user.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class UserInfoQueryDTO {

    private Integer current = 1;

    private Integer pageSize = 20;

    private String username;

}
