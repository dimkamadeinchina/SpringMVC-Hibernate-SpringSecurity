package com.example.dao;

import com.example.model.User;

import java.io.Serializable;

public interface UserDao {
    User findById(Serializable id);

    void save(User user);
}
