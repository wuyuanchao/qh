package com.chic.qh.controller.user;

import com.chic.qh.controller.user.dto.CurrentUserResp;
import com.chic.qh.controller.user.dto.LoginReq;
import com.chic.qh.controller.user.dto.LoginResp;
import com.chic.qh.controller.user.dto.UserDTO;
import com.chic.qh.domain.dal.model.UserInfo;
import com.chic.qh.service.enquiry.vo.EnquiryOrderListVO;
import com.chic.qh.service.user.UserInfoService;
import com.chic.qh.service.user.dto.UserInfoAddUpdateDTO;
import com.chic.qh.service.user.dto.UserInfoQueryDTO;
import com.chic.qh.service.user.vo.UserInfoListVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login/outLogin")
    public ResponseEntity outLogin(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/currentUser")
    public ResponseEntity currentUser(Authentication authentication){
        UserInfo userInfo = userInfoService.queryUserByUserName(authentication.getName());
        return ResponseEntity.ok(new CurrentUserResp(true, new UserDTO(authentication.getName(),
                userInfo.getAvatar(),
                String.valueOf(userInfo.getUserId()), authentication.getAuthorities().toString())));
    }

    @GetMapping("/users")
    public ResponseEntity users(UserInfoQueryDTO dto){
        UserInfoListVO vo = userInfoService.queryList(dto);
        return ResponseEntity.ok(vo);
    }

    @PostMapping("/addUpdateUser")
    public ResponseEntity addUpdateUser(@RequestBody UserInfoAddUpdateDTO dto){
        //encoder password
        encodePassword(dto);
        userInfoService.addUpdateUser(dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 密码加密
     * todo: 应该放到service层去做，但是spring-security的依赖在controller层
     * @param dto
     */
    private void encodePassword(UserInfoAddUpdateDTO dto){
        if(StringUtils.isNotBlank(dto.getPassword())){
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
    }

}
