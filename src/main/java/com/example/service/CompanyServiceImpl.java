package com.example.service;

import com.example.dao.CompanyDao;
import com.example.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl {

    @Autowired
    private CompanyDao companyDao;

    public Company getCompanyById(int id){
        return companyDao.findById(id);
    }

    public List<Company> getAllCompanies(){
        return companyDao.getAllCompanies();
    }
}
