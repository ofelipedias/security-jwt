package com.spring.security.controller;

import com.spring.security.exception.UserNotFoundException;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") BigDecimal id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal saveUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

}
