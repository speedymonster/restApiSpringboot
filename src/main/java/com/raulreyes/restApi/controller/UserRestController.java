package com.raulreyes.restApi.controller;

import com.raulreyes.restApi.entity.User;
import com.raulreyes.restApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        userService.save(new User(1,"a","aa"));
        return null;
    }
}
