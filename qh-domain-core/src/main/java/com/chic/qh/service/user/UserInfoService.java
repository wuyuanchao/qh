package com.chic.qh.service.user;

import com.chic.qh.domain.dal.model.UserInfo;
import com.chic.qh.service.user.dto.UserInfoAddUpdateDTO;
import com.chic.qh.service.user.dto.UserInfoQueryDTO;
import com.chic.qh.service.user.vo.UserInfoListVO;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-05-16 21:45
 */
public interface UserInfoService {


    UserInfoListVO queryList(UserInfoQueryDTO dto);

    void addUpdateUser(UserInfoAddUpdateDTO dto);

    UserInfo queryUserByUserName(String name);
}
