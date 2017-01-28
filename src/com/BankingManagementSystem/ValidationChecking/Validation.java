package com.BankingManagementSystem.ValidationChecking;

import java.util.Scanner;

class Check
{
	private static Scanner sc = new Scanner(System.in);
		
    static boolean nameCheck(String name)
    {
    	String namepattern = "^[a-zA-Z]{3,5}$";
    	
    	Scanner sc1 = new Scanner(name);
    	
    	String match = sc1.findInLine(namepattern);
    	
    	if (match == null)
    		
    		return false;
    	else
    		return true;
    }
    
    static boolean emilcheck(String email)
    {
    	String emailpattern = "^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";
    	
    	
    	Scanner sc2 = new Scanner(email);
    	
    	String match1 = sc2.findInLine(emailpattern);
    	
    	if (match1 == null)
    		return false;
		else
			return true;
    }
    
    static boolean phoneCheck(String Phone)
    {
    	String phonePattern = "^[0-9]{10}$";
    	
    	Scanner sc3 = new Scanner(Phone);
    	
    	String match2 = sc3.findInLine(phonePattern);
    	
    	if (match2 == null)
    		return false;
    	
    	else
    		return true;
    }
    

}

