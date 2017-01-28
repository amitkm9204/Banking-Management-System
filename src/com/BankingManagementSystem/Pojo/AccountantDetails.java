package com.BankingManagementSystem.Pojo;

import java.io.Serializable;

public class AccountantDetails implements Serializable {

	private String AccountantName;
	private String AccountantId;
	private String AccountantPassword;
	private Double Salary;
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		this.Salary = salary;
	}
	public String getAccountantName() {
		return AccountantName;
	}
	public void setAccountantName(String accountantName) {
		AccountantName = accountantName;
	}
	public String getAccountantId() {
		return AccountantId;
	}
	public void setAccountantId(String accountantId) {
		AccountantId = accountantId;
	}
	public String getAccountantPassword() {
		return AccountantPassword;
	}
	public void setAccountantPassword(String accountantPassword) {
		AccountantPassword = accountantPassword;
	}
	
}
