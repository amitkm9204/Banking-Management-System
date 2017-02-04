package com.BankingManagementSystem.frameDesign;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.BankingManagementSystem.FileHandling.AccountantDetailsFile;
import com.BankingManagementSystem.FileHandling.ManagerDetailsFile;
import com.BankingManagementSystem.Pojo.AccountantDetails;
import com.BankingManagementSystem.Pojo.ManagerDetails;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

public class ChangePassword extends JFrame 
{

	private JPanel ChangePassword;
	private JButton btnChangePassword;
	private JLabel lblConfirmPassword;
	private JLabel lblNewPassword;
	private JLabel lblOldPassword;
	private JLabel lblChangePassword;
	private JTextField txtOldPassword;
	private JTextField txtNewPassword;
	private JTextField txtConfirmPassword;

	private int accINdex,manIndex;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public ChangePassword(AccountantDetails accDetails,int index) 
	{
		setTitle("CHANGE PASSWORD");
		setResizable(false);
		accINdex = index;
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                 
             	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             	setVisible(false);
             	dispose();
                     
                 }
         }
         );
		setBounds(100, 100, 590, 400);
		ChangePassword = new JPanel();
		ChangePassword.setBackground(new Color(245, 222, 179));
		ChangePassword.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ChangePassword);
		ChangePassword.setLayout(null);
		
		lblChangePassword = new JLabel("CHANGE PASSWORD");
		lblChangePassword.setForeground(new Color(0, 128, 0));
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblChangePassword.setBounds(92, 11, 455, 39);
		ChangePassword.add(lblChangePassword);
		
		lblOldPassword = new JLabel("OLD PASSWORD : ");
		lblOldPassword.setForeground(new Color(139, 0, 0));
		lblOldPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblOldPassword.setBounds(77, 107, 232, 39);
		ChangePassword.add(lblOldPassword);
		
		lblNewPassword = new JLabel("NEW PASSWORD : ");
		lblNewPassword.setForeground(new Color(139, 0, 0));
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewPassword.setBounds(71, 172, 238, 39);
		ChangePassword.add(lblNewPassword);
		
		lblConfirmPassword = new JLabel("CONFIRM PASSWORD : ");
		lblConfirmPassword.setForeground(new Color(139, 0, 0));
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblConfirmPassword.setBounds(10, 235, 285, 39);
		ChangePassword.add(lblConfirmPassword);
		
		btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.setBackground(new Color(147, 112, 219));
		//btnChangePassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnChangePassword.setForeground(new Color(200, 50, 50));
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChangePassword.setBounds(298, 300, 249, 39);
		ChangePassword.add(btnChangePassword);
		
		btnChangePassword.addActionListener((e)->
		{
			
			if((accDetails.getAccountantPassword()).equals(txtOldPassword.getText().trim()))
			{
				if(PasswordCheck(txtNewPassword.getText().trim()))
				{
				if((txtConfirmPassword.getText().trim()).equals(txtNewPassword.getText().trim()))
				{
					accDetails.setAccountantPassword(txtNewPassword.getText().trim());
					changeAccountant(accDetails);
					JOptionPane.showMessageDialog(this, "Password successfully changed");
					
			            	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            	setVisible(false);
			            	dispose(); 
			       
				}
				else
					JOptionPane.showMessageDialog(this, "Password mismatch");
				}
			}
			else
				JOptionPane.showMessageDialog(this, "Incorrect old password");
			
			});
		
		txtOldPassword = new JTextField();
		txtOldPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtOldPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtOldPassword.setBounds(298, 107, 264, 33);
		ChangePassword.add(txtOldPassword);
		txtOldPassword.setColumns(10);
		
		String str="<html>"+">At least 8 character"+
				   "<br>"+">Contains at least one digit"+
				   "<br>"+">Contains at least one lower alpha char and one upper alpha char"+
				   "<br>"+">Contains at least one char within a set of special chars (@#%$^ etc.)"+
				   "<br>"+">Does not contain space, tab, etc."+"</html>";
		
		txtNewPassword = new JTextField();
		txtNewPassword.setToolTipText(str);
		txtNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtNewPassword.setColumns(10);
		txtNewPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNewPassword.setBounds(298, 172, 264, 33);
		ChangePassword.add(txtNewPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtConfirmPassword.setBounds(298, 235, 264, 33);
		ChangePassword.add(txtConfirmPassword);
		
		
		setVisible(true);
	}
	public void changeAccountant(AccountantDetails change){
		ArrayList<AccountantDetails> userlist  =new  ArrayList<AccountantDetails>();
		userlist = AccountantDetailsFile.readDataFromFile();
		userlist.set(accINdex, change);
		AccountantDetailsFile.writeDatatoFile(userlist);
	}
	public ChangePassword(ManagerDetails manDetails,int index) 
	{
		setTitle("CHANGE PASSWORD");
		setResizable(false);
		manIndex = index;
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                 
             	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             	setVisible(false);
             	dispose();
                     
                 }
         }
         );
		setBounds(100, 100, 590, 400);
		ChangePassword = new JPanel();
		ChangePassword.setBackground(new Color(245, 222, 179));
		ChangePassword.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ChangePassword);
		ChangePassword.setLayout(null);
		
		lblChangePassword = new JLabel("CHANGE PASSWORD");
		lblChangePassword.setForeground(new Color(0, 128, 0));
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblChangePassword.setBounds(92, 11, 455, 39);
		ChangePassword.add(lblChangePassword);
		
		lblOldPassword = new JLabel("OLD PASSWORD : ");
		lblOldPassword.setForeground(new Color(139, 0, 0));
		lblOldPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblOldPassword.setBounds(77, 107, 232, 39);
		ChangePassword.add(lblOldPassword);
		
		lblNewPassword = new JLabel("NEW PASSWORD : ");
		lblNewPassword.setForeground(new Color(139, 0, 0));
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewPassword.setBounds(71, 172, 238, 39);
		ChangePassword.add(lblNewPassword);
		
		lblConfirmPassword = new JLabel("CONFIRM PASSWORD : ");
		lblConfirmPassword.setForeground(new Color(139, 0, 0));
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblConfirmPassword.setBounds(10, 235, 285, 39);
		ChangePassword.add(lblConfirmPassword);
		
		btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.setBackground(new Color(147, 112, 219));
		//btnChangePassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnChangePassword.setForeground(new Color(200, 50, 50));
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChangePassword.setBounds(298, 300, 249, 39);
		ChangePassword.add(btnChangePassword);
		
	
			btnChangePassword.addActionListener((e)->
			{
		
				if((manDetails.getManagerPassword()).equals(txtOldPassword.getText().trim()))
				{
					if(PasswordCheck(txtNewPassword.getText().trim()))
					{
						if((txtConfirmPassword.getText().trim()).equals(txtNewPassword.getText().trim()))
						{
						manDetails.setManagerPassword(txtNewPassword.getText().trim());
						changeManager(manDetails);
						JOptionPane.showMessageDialog(this, "Password successfully changed");
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            	setVisible(false);
		            	dispose();
						}
						else
							JOptionPane.showMessageDialog(this, "Password mismatch");
					}
				}
				else
					JOptionPane.showMessageDialog(this, "Incorrect old password");
				
				
				});
		
		
		
		txtOldPassword = new JTextField();
		txtOldPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtOldPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtOldPassword.setBounds(298, 107, 264, 33);
		ChangePassword.add(txtOldPassword);
		txtOldPassword.setColumns(10);
		
		String str="<html>"+">At least 8 character"+
				   "<br>"+">Contains at least one digit"+
				   "<br>"+">Contains at least one lower alpha char and one upper alpha char"+
				   "<br>"+">Contains at least one char within a set of special chars (@#%$^ etc.)"+
				   "<br>"+">Does not contain space, tab, etc."+"</html>";
		
		txtNewPassword = new JTextField();
		txtNewPassword.setToolTipText(str);
		txtNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtNewPassword.setColumns(10);
		txtNewPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNewPassword.setBounds(298, 172, 264, 33);
		ChangePassword.add(txtNewPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtConfirmPassword.setBounds(298, 235, 264, 33);
		ChangePassword.add(txtConfirmPassword);
		
		
		setVisible(true);
	}
	public void changeManager(ManagerDetails change)
	{
		ArrayList<ManagerDetails> userlist  =new  ArrayList<ManagerDetails>();
		userlist = ManagerDetailsFile.readDataFromFile();
		userlist.set(manIndex, change);
		ManagerDetailsFile.writeDatatoFile(userlist);
	}
	
	
	public boolean PasswordCheck(String password)
	{
		String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		
		Scanner sc1 = new Scanner(password);
    	
    	String match = sc1.findInLine(passwordPattern);
    	
    	if (match == null)
    	{
    		JOptionPane.showMessageDialog(null, "Password should be proper");
		    
    		return false;
    	}
    	else
    		return true;
	}
}

