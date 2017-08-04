package com.example.service;

import com.example.dao.RoleDao;
import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;

    public Role getRole(int id){
        return roleDao.findById(id);
    }
}
