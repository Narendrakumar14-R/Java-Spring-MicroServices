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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Loans;
import com.chase.loanUtil.EmailNotificationTask;
import com.chase.loanUtil.FraudCheckTask;
import com.chase.loanUtil.JwtUtil;
import com.chase.service.LoansService;

@RestController
@RequestMapping("/loan")
public class LoansController {

	@Autowired
	LoansService loanService;
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/userlogin")
	public String login(@RequestParam String username, @RequestParam String password) {
		if("admin".equals(username) && "admin123".equals(password)) {
			return jwtUtil.generateToken(username);
			
		} else {
			throw new RuntimeException("Invalid Credentails");
		}
	}
	
	@PostMapping("/addLoans")
	public Loans addLoans(@RequestBody Loans loan) {
		
		//Runnable fraudcheck = new FraudCheckTask(loan.getEmail());
		//new Thread(fraudcheck).start();
		
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
	public void deleteLoans(@PathVariable("loanId")  Long loanId) {
		 loanService.deleteLoans(loanId);
	}
}
