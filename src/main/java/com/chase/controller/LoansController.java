package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Loans;
import com.chase.service.LoansService;

@RestController
@RequestMapping
public class LoansController {

	@Autowired
	LoansService loanService;
	
	@PostMapping
	public Loans addLoans(Loans loan) {
		return loanService.addLoans(loan);	
	}
	
	@GetMapping
	public Loans getLoans(Long LoanId) {
		return loanService.getLoans(LoanId);
	}
	
	@GetMapping
	public List<Loans> getAllLoans(){
		return loanService.getAllLoans();
	}
	
	@PutMapping
	public Loans updateLoans(Loans loan) {
		return loanService.updateLoans(loan);
	}
	
	@DeleteMapping
	public Loans deleteLoans(Long LoanId) {
		return loanService.deleteLoans(LoanId);
	}
}
