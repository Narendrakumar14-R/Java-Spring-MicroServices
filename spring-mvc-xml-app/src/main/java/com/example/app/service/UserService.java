package com.example.app.service;

import com.example.app.model.User;
import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    void delete(int id);
    User get(int id);
    List<User> list();
}