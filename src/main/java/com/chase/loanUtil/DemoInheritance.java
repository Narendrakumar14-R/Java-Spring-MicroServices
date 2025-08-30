package com.chase.loanUtil;

import com.chase.entity.Loans;

public class DemoInheritance extends Loans{
	public static void main(String[] args) {
	
	//DemoInheritance di = new DemoInheritance();
	Loans l= new Loans();
	l.test();
	l.testinfo();
	//di.test(); // test method is from Loans class
	//di.testinfo(); // testinfo methos is from Test class
	}
	
}
