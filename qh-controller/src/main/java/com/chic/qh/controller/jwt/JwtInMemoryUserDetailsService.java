package com.chic.qh.controller.jwt;

import com.chic.qh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

//  static List<UserDetails> inMemoryUserList = new ArrayList<>();
//
//  static {
//    User.UserBuilder users = User.builder();
//    UserDetails user = users
//            .username("user")
//            .password("$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
//            .roles("USER")
//            .build();
//    UserDetails admin = users
//            .username("admin")
//
//            .roles("USER", "ADMIN")
//            .build();
//
////    inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
////        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//    inMemoryUserList.add(user);
//    inMemoryUserList.add(admin);
//  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //should be user;
    Optional<String> userDetails = userRepository.getByUsername(username);
    if (!userDetails.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }
    return User.builder()
            .username(userDetails.get())
            .password("$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
            .roles("USER")
            .build();
  }

}


