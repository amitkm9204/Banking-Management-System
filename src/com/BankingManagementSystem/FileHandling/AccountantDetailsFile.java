package com.BankingManagementSystem.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.BankingManagementSystem.Pojo.AccountantDetails;

public class AccountantDetailsFile {
	public static ArrayList<AccountantDetails> readDataFromFile()
	{
		ArrayList<AccountantDetails> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("AccountantDetails.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<AccountantDetails>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<AccountantDetails>();
		 }
		 
		return list4;
		
	}
	public static void writeDatatoFile(ArrayList<AccountantDetails> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("AccountantDetails.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}



}
