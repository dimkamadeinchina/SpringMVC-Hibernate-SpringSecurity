package com.example.dao;

import com.example.Util.HibernateUtil;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao {


   @Autowired
    private HibernateUtil hibernateUtil;


    @Override
    public User findById(Serializable id) {
        return hibernateUtil.fetchById(User.class, id);
    }


    @Override
    public void save(User user) {
        hibernateUtil.save(user);
    }

    @Override
    public void update(User user) {
        hibernateUtil.update(user);
    }

}
