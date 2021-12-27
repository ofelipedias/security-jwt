package com.spring.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Secured("ROLE_USER")
    @GetMapping
    public String hello() {
        return "Hello fucking world!!!";
    }
}
