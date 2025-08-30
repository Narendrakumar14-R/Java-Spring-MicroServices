package com.sample.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.dto.UserRegistrationDTO;
import com.sample.service.RegistrationDAO;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationDAO registrationDAO;
    
    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userRegInfo") UserRegistrationDTO userRegistrationDTO) {
        return "registration-page";
    }
    
    @RequestMapping(value = "/registration-complete", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("userRegInfo") UserRegistrationDTO dto,Model model) {
        registrationDAO.saveRegistration(dto);
        model.addAttribute("userRegInfo", dto);
        return "registration-complete";
    }

}

