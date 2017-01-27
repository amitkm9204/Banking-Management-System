package com.BankingManagementSystem.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.BankingManagementSystem.Pojo.AccountantDetails;

public class ManagerDetails {

	public static ArrayList<ManagerDetails> readDataFromFile()
	{
		ArrayList<ManagerDetails> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("ManagerDetails.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<ManagerDetails>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<ManagerDetails>();
		 }
		 
		return list4;
		
	}
	public static void writeDatatoFile(ArrayList<ManagerDetails> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("ManagerDetails.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}
