package com.sample.service;

import com.sample.dto.UserRegistrationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrationDAOImpl implements RegistrationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveRegistration(UserRegistrationDTO dto) {
        String sql = "INSERT INTO registration (name, username, password, branch, skills, gender) VALUES (?, ?, ?, ?, ?, ?)";
        String combinedSkills = String.join(",", dto.getSkills());

        jdbcTemplate.update(sql,
            dto.getName(),
            dto.getUserName(),
            dto.getPassword(),
            dto.getBranch(),
            combinedSkills,
            dto.getGender()
        );
    }
}
