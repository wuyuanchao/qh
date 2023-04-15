package com.chic.qh.controller.user;

import com.chic.qh.controller.user.dto.CurrentUserResp;
import com.chic.qh.controller.user.dto.LoginReq;
import com.chic.qh.controller.user.dto.LoginResp;
import com.chic.qh.controller.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private static final Map<String, LoginReq> ACCOUNTS = Arrays.asList(
            new LoginReq("admin", "123456", ""),
            new LoginReq("user", "654321", ""))
            .stream()
            .collect(Collectors.toMap(LoginReq::getUsername, Function.identity()));

    private static final Set<String> LOGIN_USERS = new HashSet<>();

    @PostMapping("/api/login/account")
    public LoginResp list(@RequestBody LoginReq req) {
        if(Optional.ofNullable(ACCOUNTS.get(req.getUsername()))
                .filter(x -> x.getPassword().equals(req.getPassword()))
                .isPresent()) {
            LOGIN_USERS.add(req.getUsername());

            LoginResp resp = new LoginResp();
            resp.setCurrentAuthority("admin");
            resp.setType(req.getType());
            resp.setStatus("ok");
            return resp;
        }else{
            LoginResp resp = new LoginResp();
            resp.setCurrentAuthority("guest");
            resp.setType(req.getType());
            resp.setStatus("error");
            return resp;
        }
    }

    @PostMapping("/api/login/outLogin")
    public ResponseEntity outLogin(){
        LOGIN_USERS.clear();
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/api/currentUser")
    public ResponseEntity currentUser(){
        if(LOGIN_USERS.size() > 0) {
            return ResponseEntity.ok(new CurrentUserResp(true, new UserDTO("桃花仙翁",
                    "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png",
                    "00000001")));
        }else{
            Map<String, Object> map = new HashMap<>();
            map.put("errorCode", "401");
            map.put("errorMessage", "请先登录！");
            map.put("success", true);

            Map<String, Object> data = new HashMap<>();
            data.put("isLogin", false);
            map.put("data", data);
            return ResponseEntity.status(401).body(map);
        }
    }
}
