package com.example.app.controller;

import com.example.app.model.Transaction;
import com.example.app.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", transactionService.list());
        return "transaction-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("transaction") Transaction txn) {
        if (txn.getId() == 0)
            transactionService.save(txn);
        else
            transactionService.update(txn);
        return "redirect:/transactions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("transaction", transactionService.get(id));
        return "transaction-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        transactionService.delete(id);
        return "redirect:/transactions";
    }
}