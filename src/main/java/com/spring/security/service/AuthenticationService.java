package com.spring.security.service;

import com.spring.security.model.AuthenticationRequest;

public interface AuthenticationService {

    public String authenticate(AuthenticationRequest authenticationRequest);
}
