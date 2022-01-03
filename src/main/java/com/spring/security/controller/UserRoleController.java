package com.spring.security.controller;

import com.spring.security.exception.RoleNotFoundException;
import com.spring.security.exception.UserNotFoundException;
import com.spring.security.model.Role;
import com.spring.security.model.User;
import com.spring.security.repository.RoleRepository;
import com.spring.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RequestMapping("/user/roles")
@RestController
public class UserRoleController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void saveUserRole(@RequestParam("user_id") Long userId,
                             @RequestParam("role_id") Long roleId) {

        Role role = roleRepository.findById(BigDecimal.valueOf(roleId)).orElseThrow(RoleNotFoundException::new);
        User user = userRepository.findById(BigDecimal.valueOf(userId)).orElseThrow(UserNotFoundException::new);
        user.getUserRoles().add(role);
        userRepository.saveAndFlush(user);
    }

}
