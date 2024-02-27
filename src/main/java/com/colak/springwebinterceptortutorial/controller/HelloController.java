package com.colak.springwebinterceptortutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    // http://localhost:8080/api/v1/hello
    @GetMapping
    String greet() {
        return "Hello";
    }
}
