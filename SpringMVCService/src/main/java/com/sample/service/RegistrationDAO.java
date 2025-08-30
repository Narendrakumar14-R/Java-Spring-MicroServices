package com.sample.service;

import com.sample.dto.UserRegistrationDTO;

public interface RegistrationDAO {
	void saveRegistration(UserRegistrationDTO dto);
}
