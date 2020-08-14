package com.spring.security.rest.controller;

import com.spring.security.model.AuthenticationRequest;
import com.spring.security.model.AuthenticationResponse;
import com.spring.security.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        String token = authenticationService.authenticate(authenticationRequest);
        return new AuthenticationResponse(token);
    }
}
