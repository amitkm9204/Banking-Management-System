package com.BankingManagementSystem.frameDesign;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.UIManager;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;



@SuppressWarnings("serial")
class LoginManager extends JFrame
{
	private JPanel AdminPage;
	private Panel LoginPage;
	private JLabel lblPassword,lbUserId;
	private JTextField textUserId;
	private JPasswordField txtPassword;
	private JButton btnLogIn;
	private JCheckBox chckbxShowPassword;
	
	
	
	public LoginManager() 
	{
		formOpen();
		
	}
	
	

	private void formOpen() 
	{
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLoginPage.class.getResource("/resources/1485472416_Banking_00019_A.png")));
		setTitle("Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 780);
		AdminPage = new JPanel();
		AdminPage.setBackground(new Color(176, 224, 230));
		AdminPage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AdminPage);
		AdminPage.setLayout(null);
		
		/*lblBankingManagementSystem = new JLabel("BANKING MANAGEMENT SYSTEM");
		lblBankingManagementSystem.setLabelFor(this);
		lblBankingManagementSystem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBankingManagementSystem.setForeground(new Color(219, 112, 147));
		lblBankingManagementSystem.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 48));
		lblBankingManagementSystem.setBounds(248, 21, 854, 52);
		AdminPage.add(lblBankingManagementSystem);*/
		
		LoginPage = new Panel();
		LoginPage.setBackground(new Color(240, 230, 140));
		LoginPage.setForeground(new Color(255, 127, 80));
		LoginPage.setBounds(341, 275, 660, 400);
		AdminPage.add(LoginPage);
		LoginPage.setLayout(null);
		
		JLabel lblLogIn = new JLabel("-----LOG IN------------------------------------------------------------------");
		lblLogIn.setBounds(3, 5, 654, 27);
		lblLogIn.setForeground(new Color(128, 0, 128));
		lblLogIn.setFont(new Font("Script MT Bold", Font.BOLD, 22));
		LoginPage.add(lblLogIn);
		
		lbUserId = new JLabel("USER ID");
		lbUserId.setForeground(new Color(220, 20, 60));
		lbUserId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 28));
		lbUserId.setBounds(119, 89, 94, 51);
		LoginPage.add(lbUserId);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(220, 20, 60));
		lblPassword.setFont(new Font("Tekton Pro Cond", Font.BOLD, 28));
		lblPassword.setBounds(85, 177, 128, 51);
		LoginPage.add(lblPassword);
		
		textUserId = new JTextField();
		textUserId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		textUserId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUserId.setBounds(237, 89, 360, 40);
		LoginPage.add(textUserId);
		textUserId.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword.setBounds(237, 177, 360, 40);
		LoginPage.add(txtPassword);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setBorderPainted(false);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnLogIn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogIn.setForeground(new Color(255, 140, 0));
		btnLogIn.setBackground(new Color(176, 224, 230));
		btnLogIn.setBounds(451, 251, 146, 51);
		LoginPage.add(btnLogIn);

		chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		chckbxShowPassword.setBackground(new Color(240, 230, 140));
		chckbxShowPassword.setBounds(237, 236, 128, 23);
		LoginPage.add(chckbxShowPassword);
		
		JLabel lblManager = new JLabel("MANAGER");
		lblManager.setForeground(new Color(219, 112, 147));
		lblManager.setFont(new Font("Trajan Pro 3", Font.BOLD, 48));
		lblManager.setBounds(600, 21, 854, 52);
		AdminPage.add(lblManager);
		
	}
	
}


public class AdminLoginPage 
{

	public static void main(String[] args) 
	{
		
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginManager manager = new LoginManager();
					manager.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});

	}

}
