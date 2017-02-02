package com.BankingManagementSystem.ValidationChecking;
import java.util.ArrayList;

import com.BankingManagementSystem.FileHandling.*;
import com.BankingManagementSystem.frameDesign.*;
import com.BankingManagementSystem.Pojo.*;

public class EmailValid {
	int accNo;
	String a="receiverEmail";
	//ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();	
	
	public void Email(String msg) 
	{
		//int i=Search.searchId(accno);
		//a=userlist.get(i).getCemailid();
		
		String[] to={a};
	try{	
		if(EmailSender.sendMail("sendersEmail", "password",msg,to))
		{
			System.out.println("email sent");
		}
		else
			System.out.println("error occured");
	 }catch (Exception e) {
		System.out.println(e);
	}
	}
	
	
	/*
	public static void main(String[] args){
		EmailValid obj=new EmailValid();
		
		//obj.main(); //passing account number
	}
	*/
	

}
