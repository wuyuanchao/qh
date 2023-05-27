package com.chic.qh.service.user.vo;

import lombok.Data;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-05-16 21:47
 */
@Data
public class UserInfoVO {

    /**
     *   用户ID
     */
    private Integer userId;

    /**
     *   用户名
     */
    private String username;

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

    /**
     *   创建时间
     */
    private Integer gmtCreated;

    /**
     *   修改时间
     */
    private Integer gmtModify;

}
