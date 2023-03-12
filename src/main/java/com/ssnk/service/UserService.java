package com.ssnk.service;

import com.ssnk.entity.User;

import java.util.List;

public interface UserService {
    void insert(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
    User getUser(int id);
    User findUserByUsername(String username);
}
