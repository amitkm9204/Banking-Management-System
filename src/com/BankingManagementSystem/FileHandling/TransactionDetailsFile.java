package com.BankingManagementSystem.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.BankingManagementSystem.Pojo.TransactionSummary;;

public class TransactionDetailsFile {

	public static ArrayList<TransactionSummary> readDataFromFile()
	{
		ArrayList<TransactionSummary> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("Transaction.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<TransactionSummary>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<TransactionSummary>();
		 }
		 
		return list4;
		
	}
	public static void writeDatatoFile(ArrayList<TransactionSummary> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("Transaction.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}
