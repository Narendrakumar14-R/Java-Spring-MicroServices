package com.example.app.service;

import com.example.app.model.Transaction;
import java.util.List;

public interface TransactionService {
    void save(Transaction transaction);
    void update(Transaction transaction);
    void delete(int id);
    Transaction get(int id);
    List<Transaction> list();
}