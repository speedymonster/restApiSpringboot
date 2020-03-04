package com.raulreyes.restApi.service;

import com.raulreyes.restApi.dao.UserDAO;
import com.raulreyes.restApi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        List<User> listUsers = userDAO.findAll();
        return listUsers;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(int id) {

    }
}
