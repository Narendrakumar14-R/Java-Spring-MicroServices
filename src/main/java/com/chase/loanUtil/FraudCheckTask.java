package com.chase.loanUtil;

public class FraudCheckTask implements Runnable{
	public final String loanemail;
	

	public FraudCheckTask(String loanemail) {
		super();
		this.loanemail = loanemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome loanemail:hello" + loanemail);
			Thread.sleep(3000);
			System.out.println("loanemail send to " +loanemail);
		}
		catch(InterruptedException e) {
			System.out.println("loanemail sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
