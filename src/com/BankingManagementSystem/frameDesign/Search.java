package com.BankingManagementSystem.frameDesign;

import java.util.ArrayList;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;

public class Search 
{
	public static int searchId(String strId)
	{
		//System.out.println(strId);
		ArrayList<CustomerDetails> cList;
		int f = -1;
		try
		{
			cList=CustomerDetailsFile.readDataFromFile();
			
			for(int p=0; p<cList.size(); p++)
			{
				if(strId.equals(cList.get(p).getAccountNo()))
				{
				   f = p;
				   break;
				}	
			}
			 
			return(f);
		}catch(Exception e)
		{
			System.out.println(e);
			return(-2);
		}
 	}
}
