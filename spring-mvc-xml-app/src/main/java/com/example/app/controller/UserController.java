package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", userService.list());
        return "user-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("users", new User());
        return "user-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        if (user.getId() == 0)
            userService.save(user);
        else
            userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("users", userService.get(id));
        return "user-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}