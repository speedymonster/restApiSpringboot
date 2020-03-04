package com.raulreyes.restApi.controller;

import com.raulreyes.restApi.entity.User;
import com.raulreyes.restApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(path = "/user",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findById(id);
        return user;
    }

}
