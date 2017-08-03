package com.example.service;

import com.example.dao.RecordDaoImpl;
import com.example.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordServiceImpl {

    @Autowired
    private RecordDaoImpl recordDao;

    public List<Record> getRecordsByUsername(String username){
        return recordDao.getAllRecordsById(username);
    }

    public void createRecord(Record record){
        recordDao.createRecord(record);
    }
}