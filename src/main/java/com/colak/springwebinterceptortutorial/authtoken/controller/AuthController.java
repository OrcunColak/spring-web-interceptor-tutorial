package com.colak.springwebinterceptortutorial.authtoken.controller;

import com.colak.springwebinterceptortutorial.authtoken.annotation.ThirdPartyAuthToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/thirdPartyService1/")
public class AuthController {

    // http://localhost:8080/api/thirdPartyService1/getProducts
    @GetMapping(value = "getProducts")
    public String getProducts(@ThirdPartyAuthToken String authToken) {
        return authToken;
    }
}
