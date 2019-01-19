package com.profile.example.springprofileexample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class UserService {

    @Value("${spring.message}")
    private String message;

    @GetMapping("/msg")
    public String getMessage(){
        return message;
    }
}
