package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Loans;
import com.chase.service.LoansService;

@RestController
@RequestMapping
public class LoansController {

	@Autowired
	LoansService loanService;
	
	@PostMapping("/addLoans")
	public Loans addLoans(@RequestBody Loans loan) {
		return loanService.addLoans(loan);	
	}
	
	@GetMapping("/getLoans/{loanId}")
	public Loans getLoans(@PathVariable("loanId") Long loanId) {
		return loanService.getLoans(loanId);
	}
	
	@GetMapping("/getAllLoans")
	public List<Loans> getAllLoans(){
		return loanService.getAllLoans();
	}
	
	@PutMapping("/updateLoans")
	public Loans updateLoans(@RequestBody Loans loan) {
		return loanService.updateLoans(loan);
	}
	
	@DeleteMapping("/deleteLoans/{loanId}")
	public Loans deleteLoans(@PathVariable("loanId")  Long loanId) {
		return loanService.deleteLoans(loanId);
	}
}
