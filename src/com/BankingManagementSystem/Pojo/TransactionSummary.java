package com.BankingManagementSystem.Pojo;

import java.io.Serializable;

public class TransactionSummary implements Serializable{

	private String AccNo;
	private String DateAndTime;
	public String getDateAndTime() {
		return DateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		DateAndTime = dateAndTime;
	}
	//private String time;
	private Double Deposite;
	private Double Withdrawal;
	private Double balance;
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccNo() {
		return AccNo;
	}
	public void setAccNo(String accNo) {
		AccNo = accNo;
	}
	public Double getDeposite() {
		return Deposite;
	}
	public void setDeposite(Double deposite) {
		Deposite = deposite;
	}
	public Double getWithdrawal() {
		return Withdrawal;
	}
	public void setWithdrawal(Double withdrawal) {
		Withdrawal = withdrawal;
	}
	
	public TransactionSummary(String accNo, String dateAndTime, Double deposite, Double withdrawal) {
		super();
		AccNo = accNo;
		DateAndTime = dateAndTime;
		
		Deposite = deposite;
		Withdrawal = withdrawal;
	}
	public TransactionSummary() {
		// TODO Auto-generated constructor stub
	}
	
}
