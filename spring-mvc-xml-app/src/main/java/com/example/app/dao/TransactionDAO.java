package com.example.app.dao;

import com.example.app.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    void save(Transaction transaction);
    void update(Transaction transaction);
    void delete(int id);
    Transaction get(int id);
    List<Transaction> list();
}