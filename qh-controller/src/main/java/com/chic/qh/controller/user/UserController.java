package com.chic.qh.controller.user;

import com.chic.qh.controller.user.dto.CurrentUserResp;
import com.chic.qh.controller.user.dto.LoginReq;
import com.chic.qh.controller.user.dto.LoginResp;
import com.chic.qh.controller.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/login/outLogin")
    public ResponseEntity outLogin(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/currentUser")
    public ResponseEntity currentUser(Authentication authentication){
        return ResponseEntity.ok(new CurrentUserResp(true, new UserDTO(authentication.getName(),
                "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png",
                "00000001", authentication.getAuthorities().toString())));
    }

}
