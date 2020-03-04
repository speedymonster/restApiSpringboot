package com.raulreyes.restApi.service;

import com.raulreyes.restApi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    String deleteById(int id);
}
