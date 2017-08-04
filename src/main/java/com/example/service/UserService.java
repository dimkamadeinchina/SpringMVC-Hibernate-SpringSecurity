package com.example.service;

import com.example.model.User;

public interface UserService {
    void saveLastLoginDate(String username);

    User getUser(String username);
    void saveUser(User user);
    void updateUser(User user);
}
