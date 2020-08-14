package com.spring.security.controller;

import com.spring.security.exception.UserNotFoundException;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") BigDecimal id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
