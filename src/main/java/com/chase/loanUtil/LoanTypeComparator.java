package com.chase.loanUtil;

import java.util.Comparator;

import com.chase.entity.Loans;

public class LoanTypeComparator implements Comparator<Loans> {

	@Override
	public int compare(Loans o1, Loans o2) {
		// TODO Auto-generated method stub
		return o1.getLoanType().compareToIgnoreCase(o2.getLoanType());
	}

}
