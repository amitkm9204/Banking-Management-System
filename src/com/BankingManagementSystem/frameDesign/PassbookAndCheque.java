package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

class PassbookCheque extends JFrame
{
	private JPanel PassbookAndCheque;
	private JTextField txtAccountNumber;
	private JTextField txtCustomerName;
	
	
	public PassbookCheque()
	{
		formOpen();
		
	}
	
	

	private void formOpen()
	{
		
		setResizable(false);
		setTitle("PASSBOOK AND CHEQUE BOOK");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		PassbookAndCheque = new JPanel();
		PassbookAndCheque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PassbookAndCheque.setBackground(new Color(240, 255, 240));
		PassbookAndCheque.setName("Passbook And Cheque");
		PassbookAndCheque.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(PassbookAndCheque);
		PassbookAndCheque.setLayout(null);
		
		JLabel lblPassbookAndCheque = new JLabel("PASSBOOK AND CHEQUE CONFIRMATION");
		lblPassbookAndCheque.setForeground(new Color(128, 128, 0));
		lblPassbookAndCheque.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblPassbookAndCheque.setBackground(new Color(245, 222, 179));
		lblPassbookAndCheque.setBounds(10, 11, 574, 31);
		PassbookAndCheque.add(lblPassbookAndCheque);
		
		JLabel lblNewLabel = new JLabel("Account Number :");
		lblNewLabel.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBounds(23, 147, 220, 31);
		PassbookAndCheque.add(lblNewLabel);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setToolTipText("Enter Account Number");
		txtAccountNumber.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		txtAccountNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAccountNumber.setBounds(253, 147, 313, 31);
		PassbookAndCheque.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		JLabel lblName = new JLabel("CUSTOMER NAME :");
		lblName.setForeground(new Color(255, 69, 0));
		lblName.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblName.setBounds(23, 231, 212, 31);
		PassbookAndCheque.add(lblName);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setToolTipText("Enter Customer Name");
		txtCustomerName.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCustomerName.setBounds(253, 231, 313, 31);
		PassbookAndCheque.add(txtCustomerName);
		
		JButton btnNewButton = new JButton("COMFIRM");
		btnNewButton.setToolTipText("Please Confirm");
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(396, 336, 170, 55);
		PassbookAndCheque.add(btnNewButton);
		
		setVisible(true);
	}
	
}

public class PassbookAndCheque 
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PassbookCheque pc = new PassbookCheque();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});

	}

}
