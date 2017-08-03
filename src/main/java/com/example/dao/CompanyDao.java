package com.example.dao;

import com.example.model.Company;

import java.io.Serializable;
import java.util.List;

public interface CompanyDao {
    Company findById(Serializable id);
    List<Company> getAllCompanies();
}
