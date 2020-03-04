package com.raulreyes.restApi.dao;
import com.raulreyes.restApi.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void deleteById(int id);
}
