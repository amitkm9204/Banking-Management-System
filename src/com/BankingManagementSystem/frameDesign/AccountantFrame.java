package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

class AccountantFrame extends JFrame
{

	private JPanel accountantPage ;
	private Panel DisplayPage;
	private JButton btnAddAccount;
	private JButton btnRemoveAccount;
	private JButton btnUpdateDetails;
	private JButton btnTransaction;
	private JLabel lblViewDetals;
	private JLabel lblAccountantAccess;
	
	private JComboBox View;
	
	public AccountantFrame() 
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
		
		setResizable(false);
		setTitle("ACCOUNTANT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 700, 600);
		accountantPage = new JPanel();
		accountantPage .setBackground(new Color(255, 239, 213));
		accountantPage .setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(accountantPage );
		accountantPage .setLayout(null);
		
		btnAddAccount = new JButton("ADD ACCOUNT ");
		btnAddAccount.setToolTipText("REGISTER NEW ACCOUNT");
		btnAddAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddAccount.setForeground(new Color(0, 70, 60));
		btnAddAccount.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnAddAccount.setBounds(162,121,360,60);
		accountantPage.add(btnAddAccount);
		
		btnAddAccount.addActionListener((e)->
		{
			accountOpen();
		});
		
		btnRemoveAccount = new JButton("REMOVE ACCOUNT ");
		btnRemoveAccount.setToolTipText("REMOVE AN ACCOUNT");
		btnRemoveAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnRemoveAccount.setForeground(new Color(0, 20, 60));
		btnRemoveAccount.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnRemoveAccount.setBounds(162,204,360,60);
		accountantPage.add(btnRemoveAccount);
		
		btnRemoveAccount.addActionListener((e)->
		{
			accountRemove();
		});
		
		
		btnUpdateDetails = new JButton("UPDATE ACCOUNT ");
		btnUpdateDetails.setToolTipText("CHANGE ADDRESS AND PHONE NUMBER");
		btnUpdateDetails.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnUpdateDetails.setForeground(new Color(0, 20, 60));
		btnUpdateDetails.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnUpdateDetails.setBounds(162,284,360,60);
		accountantPage.add(btnUpdateDetails);
	
		btnUpdateDetails.addActionListener((e)->
		{
			accountUpdate();
		});
		
		btnTransaction = new JButton("TRANSACTION");
		btnTransaction.setToolTipText("FUND WITHDRAW, DEPOSITE AND TRANSFER");
		btnTransaction.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnTransaction.setForeground(new Color(0, 20, 60));
		btnTransaction.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnTransaction.setBounds(162,362,360,60);
		accountantPage.add(btnTransaction);
	
		btnTransaction.addActionListener((e)->
		{
			accountTransaction();
		});
		
		
		lblViewDetals = new JLabel("VIEW ACCOUNT:");
		lblViewDetals.setToolTipText("ACCESS ACCOUNT");
		lblViewDetals.setForeground(new Color(0, 20, 60));
		lblViewDetals.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		lblViewDetals.setBounds(253, 446, 178, 40);
		accountantPage.add(lblViewDetals);
		
		
		
	/*	
		txtAddAccount = new JTextField();
		txtAddAccount.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAddAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddAccount.setBounds(270, 75, 360, 40);
		accountantPage.add(txtAddAccount);
		txtAddAccount.setColumns(10);
		

		txtRemoveAccount = new JTextField();
		txtRemoveAccount.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtRemoveAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRemoveAccount.setBounds(270, 168, 360, 40);
		accountantPage.add(txtRemoveAccount);
		txtRemoveAccount.setColumns(10);
		
		txtUpdate = new JTextField();
		txtUpdate.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtUpdate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUpdate.setBounds(270, 255, 360, 40);
		accountantPage.add(txtUpdate);
		txtUpdate.setColumns(10);
		
		txtTransaction = new JTextField();
		txtTransaction.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtTransaction.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTransaction.setBounds(270, 345, 360, 40);
		accountantPage.add(txtTransaction);
		txtTransaction.setColumns(10);*/
		
		String str[] = {"Account wise","All Accounts"};
		
		JComboBox View = new JComboBox(str);
		View.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		View.setBounds(162, 483, 360, 40);
		View.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		accountantPage.add(View);
		
		if(View.getSelectedItem().equals("Account wise"))
		{
			openAccountWise();
		}
		else if(View.getSelectedItem().equals("All Accounts"))
		{
			openAllAccount();
		}
			
		lblAccountantAccess = new JLabel("ACCOUNTANT PANEL");
		lblAccountantAccess.setForeground(new Color(139, 0, 139));
		lblAccountantAccess.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAccountantAccess.setBounds(128, 22, 467, 39);
		accountantPage.add(lblAccountantAccess);	
		this.setVisible(true);
	
	}
	public void openAllAccount()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new AllDetailsCustomer();
                
            }
        });
	}
	public void openAccountWise()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new AllDetailsAccountant();
                
            }
        });
	}
	public void accountOpen()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new AccountOpening();
                
            }
        });
	}
	public void accountRemove()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DeleteAccountFrame();
                
            }
        });
	}
	public void accountUpdate()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new UpdateAccountFrame();
                
            }
        });
	}
	public void accountTransaction()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TransactionFrame("Transaction");
                
            }
        });
	}
}

/*public  class AccountantFrame
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Accountantform accountant = new Accountantform();
					accountant.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/




