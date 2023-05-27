package com.chic.qh.service.user.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-05-16 21:47
 */
@Data
public class UserInfoListVO {

    private Long total;

    private List<UserInfoVO> userList;

    public UserInfoListVO() {
    }

    public UserInfoListVO(Long total, List<UserInfoVO> userList) {
        this.total = total;
        this.userList = userList;
    }
}
