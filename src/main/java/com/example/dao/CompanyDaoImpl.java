package com.example.dao;

import com.example.Util.HibernateUtil;
import com.example.model.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public Company findById(Serializable id) {
        return hibernateUtil.fetchById(Company.class, id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return hibernateUtil.fetchAll(Company.class);
    }

}
