package com.chic.qh.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<String> getByUsername(String username) {
        if(Arrays.asList("admin", "user", "wuyc").contains(username)){
            return Optional.ofNullable(username);
        }else{
            return Optional.ofNullable(null);
        }
    }
}
