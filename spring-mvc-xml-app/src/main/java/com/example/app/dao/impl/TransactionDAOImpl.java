package com.example.app.dao.impl;

import com.example.app.dao.TransactionDAO;
import com.example.app.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    private JdbcTemplate jdbcTemplate;

    public TransactionDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (description, amount) VALUES (?, ?)";
        jdbcTemplate.update(sql, transaction.getDescription(), transaction.getAmount());
    }

    public void update(Transaction transaction) {
        String sql = "UPDATE transactions SET description=?, amount=? WHERE id=?";
        jdbcTemplate.update(sql, transaction.getDescription(), transaction.getAmount(), transaction.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM transactions WHERE id=?", id);
    }

    public Transaction get(int id) {
        String sql = "SELECT * FROM transactions WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TransactionMapper());
    }

    public List<Transaction> list() {
        String sql = "SELECT * FROM transactions";
        return jdbcTemplate.query(sql, new TransactionMapper());
    }

    private static final class TransactionMapper implements RowMapper<Transaction> {
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction txn = new Transaction();
            txn.setId(rs.getInt("id"));
            txn.setDescription(rs.getString("description"));
            txn.setAmount(rs.getDouble("amount"));
            return txn;
        }
    }
}