package com.example.app.service.impl;

import com.example.app.dao.UserDAO;
import com.example.app.model.User;
import com.example.app.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public User get(int id) {
        return userDAO.get(id);
    }

    public List<User> list() {
        return userDAO.list();
    }
}