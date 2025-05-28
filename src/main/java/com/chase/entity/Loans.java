package com.chase.entity;
import java.time.LocalDate;

import com.chase.Test;


public class Loans extends Test {


    private Long loanId;              
    private String loanType;         
    private Double ROI;              
    private Long customerId;          
    private Integer loanTerm;        
    private LocalDate loanStartDate;  
    private LocalDate loanEndDate;   
    private Boolean status;
    protected String bankname;
   
    
    // hello
    
    
    
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
		
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Double getROI() {
		return ROI;
	}
	public void setROI(Double rOI) {
		ROI = rOI;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Integer getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(Integer loanTerm) {
		this.loanTerm = loanTerm;
	}
	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public LocalDate getLoanEndDate() {
		return loanEndDate;
	}
	public void setLoanEndDate(LocalDate loanEndDate) {
		this.loanEndDate = loanEndDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public void test() {
		System.out.println("Hello in Loans class");
	}
	}
