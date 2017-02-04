package com.BankingManagementSystem.ValidationChecking;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Validation
{
	private static Scanner sc = new Scanner(System.in);
	
		
    static boolean nameCheck(String name)
    {
    	String namepattern = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
    			//"^[a-zA-Z-\\+]+(\\.[A-Za-z]+){3,20}$";
    	
    	Scanner sc1 = new Scanner(name);
    	
    	String match = sc1.findInLine(namepattern);
    	
    	if (match == null)
    	{
    		JOptionPane.showMessageDialog(null, "Invalid Name..Please Enter valid name");
		    
    		return false;
    	}
    	else
    		return true;
    }
    
    static boolean emilcheck(String email)
    {
    	String emailpattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
    			//"^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";
    	
    	
    	Scanner sc2 = new Scanner(email);
    	//String match2;
    	
    	String match1 = sc2.findInLine(emailpattern);
    	
    	if (match1 == null)
    	{
    
       		
       		JOptionPane.showMessageDialog(null, "Invalid EmailId..");
		       //txt.setText("");
		      // temailid.setBackground(Color.RED);
		       return false;
    	}
		       
		else
			return true;
    }
    
    static boolean phoneCheck(String Phone)
    {
    	String phonePattern = "^[0-9]{10}$";
    	
    	Scanner sc3 = new Scanner(Phone);
    	
    	String match2 = sc3.findInLine(phonePattern);
    	
    	if (match2 == null)
    	{
    		JOptionPane.showMessageDialog(null, "Invalid Phone Number..");
    		return false;
    	}
    	
    	else
    		return true;
    }
    static boolean aadharcheck(String Adhar)
    {
    	String Pattern = "^[0-9]{16}$";
    	
    	Scanner sc3 = new Scanner(Adhar);
    	
    	String match2 = sc3.findInLine(Pattern);
    	
    	if (match2 == null)
    	{
    		JOptionPane.showMessageDialog(null, "Invalid Adhar Number..");
    		return false;
    	}
    	
    	else
    		return true;
    	
    }
    static boolean pancheck(String Pan)
    {
    	String Pattern = "^[A-Z0-9]{10}$";
    	
    	Scanner sc3 = new Scanner(Pan);
    	
    	String match2 = sc3.findInLine(Pattern);
    	
    	if (match2 == null)
    	{
    		JOptionPane.showMessageDialog(null, "Invalid PAN Number..");
    		return false;
    	}
    	
    	else
    		return true;
    	
    }
    
    
    public boolean dataValidation(String Cname,String Cmail,String Cphone,String Adhar,String PAN)
	   {	
    	
		   boolean namevalidation =  nameCheck(Cname);
		   boolean mobnovalidation = phoneCheck(Cphone);
		   boolean aadharvalidation = aadharcheck(Adhar);
		   boolean Panvalidation = pancheck(PAN);
		   boolean emailvalidation = emilcheck(Cmail);
		   
		   
		   if (namevalidation && emailvalidation && mobnovalidation && aadharvalidation && Panvalidation)
			   return true;
		   
		   return false;
	   }
	   
    

}


