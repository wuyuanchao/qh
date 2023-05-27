package com.chic.qh.service.jwt;

import com.chic.qh.repository.model.UserInfo;
import com.chic.qh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //should be user;
    Optional<UserInfo> userDetails = userRepository.getByUsername(username);
    if (!userDetails.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }
    UserInfo userInfo = userDetails.get();
    //用户非启用状态
    if(!userInfo.getStatus().equals((byte)1)){
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }
    return User.builder()
            .username(userInfo.getUsername())
            .password(userInfo.getPassword())
            .roles(userInfo.getRoleName())
            .build();
  }

}


