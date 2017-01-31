package com.BankingManagementSystem.frameDesign;
import com.BankingManagementSystem.FileHandling.AccountantDetailsFile;
import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class AllDetailsCustomer  extends JFrame{

	public AllDetailsCustomer(ArrayList<CustomerDetails> list)
	{
		
			super("Display All");
			String heading[]={"NAME","ACCOUNT NO","BALANCE"};
			String data[][];
			//ArrayList<Registration> list;
			try
			{
				list = CustomerDetailsFile.readDataFromFile();
				
				data = new String[list.size()][3];
				
				int r=0;
				for(CustomerDetails re : list)
				{
					data[r][0]=re.getCname();
					data[r][1]=re.getAccountNo();
					data[r][2]=re.getBalance().toString();
					
					r++;
				}
				
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data, heading);
				JScrollPane jsp=new JScrollPane(datatable);
				
				con.add(new JLabel("All Customer Details"),BorderLayout.NORTH);
				con.add(jsp,BorderLayout.CENTER);
				
				setSize(850, 300);
				
				setLocation(200, 200);
				setVisible(true);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			this.setVisible(true);
	}
	
	public AllDetailsCustomer() {
		this.setVisible(true);
	}
	


	
}
class AllDetailsAccountant extends JFrame
{
	public AllDetailsAccountant(ArrayList<AccountantDetails> list)
	{
		
			super("Display All");
			String heading[]={"NAME","ACCOUNTANT ID","SALARY"};
			String data[][];
			//ArrayList<Registration> list;
			try
			{
				list = AccountantDetailsFile.readDataFromFile();
				
				data = new String[list.size()][3];
				
				int r=0;
				for(AccountantDetails re : list)
				{
					data[r][0]=re.getAccountantName();
					data[r][1]=re.getAccountantId();
					data[r][2]=re.getSalary().toString();
					
					r++;
				}
				
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data, heading);
				JScrollPane jsp=new JScrollPane(datatable);
				
				con.add(new JLabel("All Customer Details"),BorderLayout.NORTH);
				con.add(jsp,BorderLayout.CENTER);
				
				setSize(850, 300);
				
				setLocation(200, 200);
				setVisible(true);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			this.setVisible(true);
		
	}

	public AllDetailsAccountant() {
		this.setVisible(true);
	}
}
