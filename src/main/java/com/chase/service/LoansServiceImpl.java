package com.chase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Loans;
import com.chase.repository.LoansRepository;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class LoansServiceImpl implements LoansService{
	
	@Autowired
	LoansRepository loansRepository;
	 

	@Override
	public Loans addLoans(Loans loan) {
		// TODO Auto-generated method stub
		if ( loan.getLoanType() == null) {
			System.out.println("The customer don't have the loan");
		}
		else {
			switch(loan.getLoanType().toLowerCase()) {
			case "education":
				System.out.println("The customer has educational loan");
				break;
			case "home":
				System.out.println("The customer has home loan");
				break;
			case "personal":
				System.out.println("The customer has Personal loan");
				break;
			default:
				System.out.println("The customer has other loans");
			}
		}
		return loansRepository.save(loan);
	}

	@Override
	public Loans getLoans(Long loanId) {
		// TODO Auto-generated method stub
		if (loanId != null && loanId > 0) {
			System.out.println("Customer having Loan");
			return loansRepository.findById(loanId).orElse(null);
		}
		else {
			System.out.println("Customer don't have a Loan");
			return null;
		}
		
	}


	@Override
	public List<Loans> getAllLoans() {
		// TODO Auto-generated method stub
		//
		// list of the loans are empty trrows exception
		//
		
		List<Loans> loans = loansRepository.findAll();
		if (loans.isEmpty()) {
		    System.out.println("There are no loans found");
		}
		else {
			loans.forEach(loan -> {
				if(loan.getStatus()) {
					System.out.println("The loan are in active staus");
				}
			} );
		}
		
		return null;
	}

	@Override
	public Loans updateLoans(Loans loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loans deleteLoans(Long LoanId) {
		// TODO Auto-generated method stub
		return null;
	}


}
