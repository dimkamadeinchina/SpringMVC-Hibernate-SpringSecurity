package com.example.dao;

import com.example.Util.HibernateUtil;
import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class RoleDao {
    @Autowired
    private HibernateUtil hibernateUtil;

    public Role findById(Serializable id) {
        return hibernateUtil.fetchById(Role.class, id);
    }
}
