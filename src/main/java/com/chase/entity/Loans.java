package com.chase.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.chase.Test;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "loans")
public class Loans extends Test {


@Id
@GeneratedValue(strategy =GenerationType.AUTO )
	
	private Long loanId;              
    private String loanType;         
    private Double ROI;              
    private Long customerId;          
    private Integer loanTerm;        
    private LocalDate loanStartDate;  
    private LocalDate loanEndDate;   
    private Boolean status;
    protected String bankname;
    private String email;
    
    
    
   @ElementCollection
   private List<String> phoneNumbers = new ArrayList<>();
   @ElementCollection
   private Map<String,Double> loanInterest = new HashMap<>();
   @ElementCollection
   private Set<String> loanTypes= new HashSet<>();
   
    
    // hello
   public List<String> getPhoneNumbers() {
		return phoneNumbers;
		}
	   public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	   }
		public Map<String,Double> getLoanInterest() {
			return loanInterest;
		}
		public void setLoanInterest(Map<String,Double> loanInterest) {
			this.loanInterest = loanInterest;
		}
		public Set<String> getLoanTypes() {
			return loanTypes;
		}
		public void setLoanTypes(Set<String> loanTypes) {
			this.loanTypes = loanTypes;
		}

    
    
    
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
	/*public void test() {
		System.out.println("Hello in Loans class");
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	}
