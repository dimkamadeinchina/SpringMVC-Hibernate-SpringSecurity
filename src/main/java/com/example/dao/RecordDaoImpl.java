package com.example.dao;

import com.example.Util.HibernateUtil;
import com.example.model.Company;
import com.example.model.Record;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RecordDaoImpl {

    @Autowired
    private HibernateUtil hibernateUtil;

    public List<Record> getAllRecordsById(String username) {
        String query = "SELECT r.* FROM history r WHERE r.username like '%"+ username +"%'";
        List<Object[]> recordObjects = hibernateUtil.fetchAll(query);
        List<Record> records = new ArrayList<>();
        for(Object[] recordObject: recordObjects) {
            Record record = new Record();
            int id = (int) recordObject[0];
            String user = (String) recordObject[1];
            String phoneNuber = (String) recordObject[2];
            int id_company = (int) recordObject[3];
            int amount = (int) recordObject[4];
            Date date = (Date) recordObject[5];
            record.setId(id);
            record.setUser(hibernateUtil.fetchById(User.class, user));
            record.setPhoneNumber(phoneNuber);
            record.setAmount(amount);
            record.setCompany(hibernateUtil.fetchById(Company.class, id_company));
            record.setDate(date);
            records.add(record);
        }
        return records;
    }
    }
