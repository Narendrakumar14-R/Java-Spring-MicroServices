package com.chase;
import com.chase.entity.Loans;
import com.chase.loanUtil.DemoPolymorphism;

public class Test {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Loans();
		Test t3 = new DemoPolymorphism();
		t1.test();
		t2.test();
		t3.test();
		
		
	
//hello
	}
	
	public void testinfo() {
		System.out.println("Narendra");
	}
	public void test() {
		System.out.println("Hello in Test class");
	}
}
