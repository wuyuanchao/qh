package com.chic.qh.service.user.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class UserInfoAddUpdateDTO {

    /**
     *   用户ID
     */
    private Integer userId;

    /**
     *   用户名
     */
    private String username;

    /**
     *   用户名
     */
    private String password;

    /**
     *   头像
     */
    private String avatar;

    /**
     *   角色名称
     */
    private String roleName;

    /**
     *   状态(1-启用;2-禁用;)
     */
    private Byte status;

}
