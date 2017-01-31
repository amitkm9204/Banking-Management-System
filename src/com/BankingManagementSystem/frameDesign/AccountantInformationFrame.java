package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;



public class AccountantInformationFrame extends JFrame
{
	private JPanel contentPane;
	private JTextField txtTotalAcc;
	private JTextField textField;
	
	
	public AccountantInformationFrame()
	{
		formopen();
	}
	
	
	private void formopen()
	{
		
		setResizable(false);
		setTitle("ACCOUNTANT INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 457);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalAccountant = new JLabel("TOTAL ACCOUNTANTS : ");
		lblTotalAccountant.setForeground(new Color(128, 0, 128));
		lblTotalAccountant.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblTotalAccountant.setBounds(30, 137, 230, 34);
		contentPane.add(lblTotalAccountant);
		
		txtTotalAcc = new JTextField();
		txtTotalAcc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTotalAcc.setFont(new Font("Consolas", Font.BOLD, 22));
		txtTotalAcc.setEditable(false);
		txtTotalAcc.setBounds(283, 138, 255, 34);
		contentPane.add(txtTotalAcc);
		txtTotalAcc.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setToolTipText("ENTER ACCOUNTANT'S USER ID");
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(283, 216, 255, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblViewAccountant = new JLabel("ACCOUNTANT ID : ");
		lblViewAccountant.setForeground(new Color(128, 0, 128));
		lblViewAccountant.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblViewAccountant.setBounds(73, 221, 193, 29);
		contentPane.add(lblViewAccountant);
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.setToolTipText("SHOW ACCOUNTANT'S DETAILS");
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(300, 296, 245, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ACCOUNTANT DETAILS");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(67, 24, 481, 46);
		contentPane.add(lblNewLabel);
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 AccountantInformationFrame frame = new AccountantInformationFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}

