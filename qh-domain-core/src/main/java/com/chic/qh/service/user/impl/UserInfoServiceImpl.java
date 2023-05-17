package com.chic.qh.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.chic.qh.domain.dal.model.UserInfo;
import com.chic.qh.repository.UserRepository;
import com.chic.qh.service.user.UserInfoService;
import com.chic.qh.service.user.dto.UserInfoAddUpdateDTO;
import com.chic.qh.service.user.dto.UserInfoQueryDTO;
import com.chic.qh.service.user.vo.UserInfoListVO;
import com.chic.qh.service.user.vo.UserInfoVO;
import com.chic.qh.utils.DateUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-05-16 21:45
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfoListVO queryList(UserInfoQueryDTO dto) {
        dto.setUsername(StringUtils.isBlank(dto.getUsername()) ? null : dto.getUsername().trim());
        Page<UserInfo> userInfoPageInfo = userRepository.queryPagedList(dto);
        //build vo
        List<UserInfoVO> userInfoVOList = userInfoPageInfo.getResult()
                .stream().map(x -> buildVO(x)).collect(Collectors.toList());
        return new UserInfoListVO(userInfoPageInfo.getTotal(), userInfoVOList);
    }

    private UserInfoVO buildVO(UserInfo userInfo) {
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfo, userInfoVO);
        return userInfoVO;
    }

    @Override
    public void addUpdateUser(UserInfoAddUpdateDTO dto) {
        if(dto.getUserId() != null && dto.getUserId() > 0){
            log.info("新增用户: dto:{}", JSONObject.toJSONString(dto));
            processUpdateUser(dto);
        }else{
            log.info("新增用户: dto:{}", JSONObject.toJSONString(dto));
            processAddUser(dto);
        }
    }

    private void processAddUser(UserInfoAddUpdateDTO dto){
        if(StringUtils.isBlank(dto.getUsername())
                || StringUtils.isBlank(dto.getPassword())
                || StringUtils.isBlank(dto.getRoleName())){
            log.warn("新增用户：参数不完整！dto:{}", JSONObject.toJSONString(dto));
            throw new RuntimeException("参数不完整");
        }
        Optional<UserInfo> userInfoOptional = userRepository.getByUsername(dto.getUsername());
        if(userInfoOptional.isPresent()){
            log.warn("新增用户：用户名已存在！username:{}", dto.getUsername());
            throw new RuntimeException("用户名已存在:" + dto.getUsername());
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(dto, userInfo);
        if(StringUtils.isBlank(dto.getAvatar())){
            //默认头像
            userInfo.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
        }
        userInfo.setStatus((byte)1);
        userInfo.setGmtCreated(DateUtils.getCurrentSecond());
        userInfo.setGmtModify(DateUtils.getCurrentSecond());
        userRepository.saveSelective(userInfo);
    }

    private void processUpdateUser(UserInfoAddUpdateDTO dto) {
        Optional<UserInfo> userInfoOptional = userRepository.getById(dto.getUserId());
        if(!userInfoOptional.isPresent()){
            log.warn("编辑用户：用户不存在！username:{}", dto.getUserId());
            throw new RuntimeException("用户不存在:" + dto.getUserId());
        }
        UserInfo userInfo = userInfoOptional.get();
        if(StringUtils.isNotBlank(dto.getAvatar())){
            userInfo.setAvatar(dto.getAvatar());
        }
        userInfo.setRoleName(dto.getRoleName());
        userInfo.setStatus(dto.getStatus());
        if(StringUtils.isNotBlank(dto.getPassword())){
            userInfo.setPassword(dto.getPassword());
        }
        userInfo.setGmtModify(DateUtils.getCurrentSecond());
        userRepository.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public UserInfo queryUserByUserName(String name) {
        return userRepository.getByUsername(name).orElse(null);
    }
}
