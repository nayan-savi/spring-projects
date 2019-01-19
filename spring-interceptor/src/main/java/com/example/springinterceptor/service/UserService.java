package com.example.springinterceptor.service;


import com.example.springinterceptor.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserService {

    @RequestMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object userAuthentication(){

        RestTemplate template = new RestTemplate();
        Object forObject = template.getForObject("https://api.github.com/users/nayan-savi", Object.class);

        return forObject;
    }
}
