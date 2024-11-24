package com.blog.auth.service.impl;

import com.blog.auth.domain.dto.MyUserDetail;
import com.blog.auth.domain.repository.RoleRepository;
import com.blog.auth.domain.repository.UserRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */
@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var currentUser =
        userRepository
            .findByUsername(username)
            .orElseThrow(
                () ->
                    new IllegalStateException(
                        String.format("User not found with username: %s", username)));
    var roles = roleRepository.findAllByUserId(currentUser.getUserId());
    var userDetail =
        new MyUserDetail(
            username,
            currentUser.getPassword(),
            roles.stream()
                .map(g -> new SimpleGrantedAuthority(g.getRole()))
                .collect(Collectors.toList()));
    userDetail.setEmail(currentUser.getEmail());
    userDetail.setFullName(currentUser.getFullName());
    userDetail.setStatus(currentUser.getStatus());
    return userDetail;
  }
}
