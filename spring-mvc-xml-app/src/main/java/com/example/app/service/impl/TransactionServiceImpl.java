package com.example.app.service.impl;

import com.example.app.dao.TransactionDAO;
import com.example.app.model.Transaction;
import com.example.app.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDAO transactionDAO;

    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public void save(Transaction transaction) {
        transactionDAO.save(transaction);
    }

    public void update(Transaction transaction) {
        transactionDAO.update(transaction);
    }

    public void delete(int id) {
        transactionDAO.delete(id);
    }

    public Transaction get(int id) {
        return transactionDAO.get(id);
    }

    public List<Transaction> list() {
        return transactionDAO.list();
    }
}