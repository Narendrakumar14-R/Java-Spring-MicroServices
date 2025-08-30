package com.chase.service;

import java.util.List;

import com.chase.entity.Loans;

public interface LoansService {
	public Loans addLoans(Loans loan);
	public Loans getLoans(Long LoanId);
	public List<Loans> getAllLoans();
	public Loans updateLoans(Loans loan);
	public void deleteLoans(Long LoanId);

}

