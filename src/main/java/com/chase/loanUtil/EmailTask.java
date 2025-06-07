package com.chase.loanUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailTask {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailTask.class);
	
   @Async("taskExecutor")
	public void sendWelcomeMail(String loantype, String loanemail) {
		// TODO Auto-generated method stub
		try {
			logger.info("in emailtask class sending welcome loantype to :" + loantype +" email:" + loanemail);
			Thread.sleep(3000);
			logger.info(" in email task loantype send to "+ loantype +" at" +loanemail);
		}
		catch(InterruptedException e) {
			logger.info("loantype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
