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
import javax.swing.border.EmptyBorder;



public class CustomerInformationFrame extends JFrame
{
	private JPanel contentPane;
	private JTextField txtTotalAcc;
	private JTextField textField;
	
	public CustomerInformationFrame()
	{
		formopen();
	}
	
	
	private void formopen()
	{
		setResizable(false);
		setTitle("Customer Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 457);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalAccountant = new JLabel("TOTAL CUSTOMER : ");
		lblTotalAccountant.setForeground(new Color(0, 0, 255));
		lblTotalAccountant.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblTotalAccountant.setBounds(41, 125, 219, 34);
		contentPane.add(lblTotalAccountant);
		
		txtTotalAcc = new JTextField();
		txtTotalAcc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTotalAcc.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtTotalAcc.setEditable(false);
		txtTotalAcc.setBounds(259, 127, 283, 34);
		contentPane.add(txtTotalAcc);
		txtTotalAcc.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		textField.setToolTipText("ENTER ACCOUNT NUMBER");
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(260, 259, 282, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblViewAccountant = new JLabel("! VIEW CUSTOMER ! ");
		lblViewAccountant.setForeground(new Color(139, 0, 0));
		lblViewAccountant.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblViewAccountant.setBounds(152, 205, 268, 26);
		contentPane.add(lblViewAccountant);
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.setToolTipText("Display all details");
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(293, 340, 249, 62);
		contentPane.add(btnNewButton);
		
		JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setForeground(new Color(0, 128, 0));
		lblCustomerDetails.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblCustomerDetails.setBounds(100, 23, 423, 41);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblAccountNumber = new JLabel("ACCOUNT NUMBER: ");
		lblAccountNumber.setForeground(Color.BLUE);
		lblAccountNumber.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblAccountNumber.setBounds(41, 259, 219, 34);
		contentPane.add(lblAccountNumber);
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 CustomerInformationFrame frame = new CustomerInformationFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}

