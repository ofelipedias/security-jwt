package com.spring.security.service.impl;

import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(username);
        if (optionalUser.isEmpty()) {
            log.warn("User not found={}", username);
            return null;
        }
        return new org.springframework.security.core.userdetails.User(
                optionalUser.get().getName(),
                optionalUser.get().getPassword(),
                getRolesByUser(optionalUser.get()));
    }

    private Collection<? extends GrantedAuthority> getRolesByUser(User user) {
        log.info("Get roles by username={}", user.getName());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<String> permissions = Collections.singletonList("ROLE_ADMIN"); // TODO criar e buscar no banco as roles
        permissions.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
        return authorities;
    }
}
