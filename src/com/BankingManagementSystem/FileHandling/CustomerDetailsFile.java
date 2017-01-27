package com.BankingManagementSystem.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.BankingManagementSystem.Pojo.CustomerDetails;

public class CustomerDetailsFile 
{
	public static ArrayList<CustomerDetails> readDataFromFile()
	{
		ArrayList<CustomerDetails> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("CustomeDetails.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<CustomerDetails>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<CustomerDetails>();
		 }
		 
		return list4;
		
	}
	public static void writeDatatoFile(ArrayList<CustomerDetails> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("CustomeDetails.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}

}
