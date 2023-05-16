package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.UserInfoDynamicSqlSupport;
import com.chic.qh.domain.dal.mapper.UserInfoMapper;
import com.chic.qh.domain.dal.model.UserInfo;
import com.chic.qh.service.user.dto.UserInfoQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;

import static com.chic.qh.domain.dal.mapper.UserInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class UserRepository {

    @Resource
    private UserInfoMapper userInfoMapper;

    public Optional<UserInfo> getByUsername(String _username) {
        return userInfoMapper.selectOne(c->c.where(username, isEqualTo(_username)));
    }

    public Page<UserInfo> queryPagedList(UserInfoQueryDTO dto) {
        return PageHelper.startPage(dto.getCurrent(), dto.getPageSize()).doSelectPage(
                () -> userInfoMapper.select(c->c
                        .where(username, isEqualToWhenPresent(dto.getUsername()))
                        .orderBy(gmtCreated.descending())
                )
        );
    }

    public int saveSelective(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    public Optional<UserInfo> getById(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
