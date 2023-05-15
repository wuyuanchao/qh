package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.UserInfoDynamicSqlSupport;
import com.chic.qh.domain.dal.mapper.UserInfoMapper;
import com.chic.qh.domain.dal.model.UserInfo;
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
}
