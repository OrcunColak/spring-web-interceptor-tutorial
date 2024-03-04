package com.colak.springwebinterceptortutorial.authtoken.service;

import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    public String getAuthToken() {
        return "my authentication token";
    }
}
