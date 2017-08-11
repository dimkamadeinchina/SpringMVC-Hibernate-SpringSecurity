package com.example.service;

import com.example.dao.RecordDaoImpl;
import com.example.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class RecordServiceImpl {

    @Autowired
    private RecordDaoImpl recordDao;

    public List<Record> getRecordsByUsername(String username){
        return recordDao.getAllRecordsById(username);
    }

    public Map<String, Integer> getMinMaxAmountByUsername(String username){
        Map<String, Integer> amountMinMax = new HashMap<>();
        List<Record> records = recordDao.getAllRecordsById(username);
        List<Integer> amounts = new ArrayList<>();

        for(Record r : records){
            amounts.add(r.getAmount());
        }

        amountMinMax.put("min", Collections.min(amounts));
        amountMinMax.put("max", Collections.max(amounts));

        return amountMinMax;
    }

    public void createRecord(Record record){
        recordDao.createRecord(record);
    }

    public List<Record> getLimitByUsername(String username, int limit) {
        return recordDao.getLimitRecordsById(username, limit);
    }

    public List<Record> getRecordsByCompany(String username, int id){
        return recordDao.getRecordsByCompany(username, id);
    }

    // НОВАЯ ПРИДУМКА
    public List<Record> getRecordsByAmount(String username, int min, int max){
        List<Record> records = recordDao.getAllRecordsById(username);
        List<Record> filteredRecords = new ArrayList<>();
        for(Record r : records){
            if(r.getAmount() >= min & r.getAmount() <= max ){
                filteredRecords.add(r);
            }
        }
        return filteredRecords;
    }
}
