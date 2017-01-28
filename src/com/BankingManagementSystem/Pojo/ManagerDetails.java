package com.BankingManagementSystem.Pojo;

import java.io.Serializable;

public class ManagerDetails implements Serializable{

	private String ManagerName;
	private String ManagerId;
	private String ManagerPassword;
	public String getManagerName() {
		return ManagerName;
	}
	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
	public String getManagerId() {
		return ManagerId;
	}
	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}
	public String getManagerPassword() {
		return ManagerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		ManagerPassword = managerPassword;
	}
	
	
}
