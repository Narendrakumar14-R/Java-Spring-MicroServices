package com.chase.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Loans;
import com.chase.loanUtil.EmailNotificationTask;
import com.chase.loanUtil.EmailTask;
import com.chase.loanUtil.GlobalExceptionHandler;
import com.chase.loanUtil.LoanNotFoundException;
import com.chase.repository.LoansRepository;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class LoansServiceImpl implements LoansService{
	
	@Autowired
	LoansRepository loansRepository;
	 @Autowired
	 EmailTask emailTask;

	@Override
	public Loans addLoans(Loans loan) {
		// TODO Auto-generated method stub
		 emailTask.sendWelcomeMail(loan.getLoanType(), loan.getEmail());
		
		try {
			
			//File f = new File("c:file123.txt");
			//f.getAbsolutePath();
			/*int i = 1/0;
			System.out.println(i);
			prints the ArithmeticException in the except block*/
			//int i ="kumar";
			
		List<String> arrayList = new ArrayList<>(loan.getPhoneNumbers());
		List<String> linkedList = new LinkedList<>(loan.getPhoneNumbers());
		
		
		long startArray = System.nanoTime();
		arrayList.add("Test-Array");
		arrayList.add("Test-Array");
		arrayList.add("Test-Array");
		long endArray = System.nanoTime();
		
		long startLinked = System.nanoTime();
		linkedList.add("Test-Linked");
		linkedList.add("Test-Linked");
		linkedList.add("Test-Linked");
		long endLinked = System.nanoTime();
		
		//System.out.println("ArrayList operation time" +(endArray - startArray)+" ns");
		//System.out.println("LinkedList operation time" +(endLinked - startLinked)+" ns");
		}
		//catch(NumberFormatException e) {
			//GlobalExceptionHandler.IllegalArgumentException(new IllegalArgumentException("Invalid Input", e));
			//e.printStackTrace();
			//System.out.println("exception called");
		//}
		finally {
			System.out.println("The finally block executes");
		}
		
		
		
		if(loan.getEmail() == null || !loan.getEmail().contains("@"))
		{
			System.out.println("Loan having invalid emial format");
			throw new LoanNotFoundException("Loan having invalid email format or emial is null");
			/* prints WARN 12388 --- [Chase_Service] [nio-8080-exec-7] .m.m.a.ExceptionHandlerExceptionResolver 
			  : Resolved [com.chase.loanUtil.LoanNotFoundException: Loan having invalid email format ot emial is null]*/
		}
		Runnable emailtask = new EmailNotificationTask(loan.getLoanType(), loan.getEmail());
		new Thread(emailtask).start();
		/*Thread emailThread = new Thread(emailtask);
		emailThread.start();

		try {
		    Thread.sleep(1000); // Give the thread time to start and reach sleep
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

		emailThread.interrupt();*/
		

		
		
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
		
		Map<String,List<Loans>> hashMap = new HashMap<>();
		Map<String,List<Loans>> linkedhashMap = new LinkedHashMap<>();
		Map<String,List<Loans>> treeMap = new TreeMap<>();
		
		for(Loans i:loans) {
			String domain = i.getEmail().split("@")[1];
			hashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(i);
			linkedhashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(i);
			treeMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(i);
		}
		System.out.println("HashMap " + hashMap.keySet());
		System.out.println("LinkedHashMap " + linkedhashMap.keySet());
		System.out.println("TreeMap " + treeMap.keySet());
		
		
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

	/**
	 *
	 */
	@Override
	public Loans updateLoans(Loans loan) {
		// TODO Auto-generated method stub
		
		Optional<Loans> l= loansRepository.findById(loan.getLoanId());
		if(l.isEmpty()) {
			throw new LoanNotFoundException("Loan not found");
			
		}
		
		
		
		
		Set<String> rawSet = loan.getLoanTypes();
		rawSet.removeIf(type -> type == null || type.trim().isEmpty());
		Set<String> hashSet = new HashSet<>(rawSet);
		System.out.println("hashSet:" + hashSet);
		
		Set<String> linkedhashSet = new LinkedHashSet<>(rawSet);
		System.out.println("linkedhashSet:" + linkedhashSet);
		
		Set<String> treeSet = new TreeSet<>(rawSet);
		System.out.println("TreeSet:" + treeSet);
		
		return null;
	}

	@Override
	public void deleteLoans(Long LoanId) {
		// TODO Auto-generated method stub
		loansRepository.deleteById(LoanId);
	}


}
