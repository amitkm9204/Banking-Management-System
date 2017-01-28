package com.BankingManagementSystem.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.BankingManagementSystem.Pojo.ManagerDetails;;

public class ManagerDetailsFile {

	public static ArrayList<ManagerDetailsFile> readDataFromFile()
	{
		ArrayList<ManagerDetailsFile> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("ManagerDetails.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<ManagerDetailsFile>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<ManagerDetailsFile>();
		 }
		 
		return list4;
		
	}
	public static void writeDatatoFile(ArrayList<ManagerDetailsFile> wlist)
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
