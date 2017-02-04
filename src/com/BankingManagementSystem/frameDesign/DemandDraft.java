package com.BankingManagementSystem.frameDesign;


import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.FileHandling.TransactionDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;
import com.BankingManagementSystem.Pojo.TransactionSummary;
import com.BankingManagementSystem.ValidationChecking.EmailValid;

import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JCheckBox;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.border.BevelBorder;

public class DemandDraft extends JFrame
{

	private JPanel dd;
	private JLabel lblPayE;
	private JLabel lblAccountNumber;
	private JLabel lblDD;
	private JTextField txtPayE;
	private JTextField txtAccountNumber;
	private JButton btnIssue;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JLabel lblName;
	private JTextField txtName;


	/*public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					DemandDraft frame = new DemandDraft();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/
	public DemandDraft() 
	{
		setTitle("DEMAND DRAFT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/draft-button.png")));
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	setVisible(false);
            	dispose();
                    
                }
        }
        );

		setBounds(100, 100, 600, 500);
		dd = new JPanel();
		dd.setBackground(new Color(135, 206, 250));
		dd.setForeground(new Color(135, 206, 250));
		dd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dd);
		dd.setLayout(null);
		
		lblDD = new JLabel("DEMAND DRAFT ISSUE");
		lblDD.setForeground(Color.RED);
		lblDD.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblDD.setBounds(10, 11, 564, 61);
		dd.add(lblDD);
		
		lblAccountNumber = new JLabel("ACCOUNT NUMBER :");
		lblAccountNumber.setFont(new Font("Consolas", Font.BOLD, 28));
		lblAccountNumber.setBounds(33, 136, 245, 47);
		dd.add(lblAccountNumber);
		
		lblPayE = new JLabel("PAYEE :");
		lblPayE.setFont(new Font("Consolas", Font.BOLD, 28));
		lblPayE.setBounds(164, 252, 107, 39);
		dd.add(lblPayE);
		
		txtPayE = new JTextField();
		txtPayE.setToolTipText("name or account number of receiver");
		txtPayE.setFont(new Font("Calibri", Font.BOLD, 20));
		txtPayE.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPayE.setBounds(294, 252, 257, 35);
		dd.add(txtPayE);
		txtPayE.setColumns(10);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setToolTipText("account number of customer apply for dd");
		txtAccountNumber.setFont(new Font("Calibri", Font.BOLD, 20));
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAccountNumber.setBounds(294, 136, 257, 35);
		dd.add(txtAccountNumber);
		
		btnIssue = new JButton("ISSUE");
		btnIssue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnIssue.setForeground(new Color(139, 0, 0));
		btnIssue.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnIssue.setBackground(new Color(106, 90, 205));
		btnIssue.setBounds(409, 389, 142, 61);
		dd.add(btnIssue);
		
		btnIssue.addActionListener((e)->
		{
			issue();
			txtAmount.setText("");
			txtAccountNumber.setText("");
			txtName.setText("");
			txtPayE.setText("");
		});
		
		lblAmount = new JLabel("AMOUNT :");
		lblAmount.setFont(new Font("Consolas", Font.BOLD, 28));
		lblAmount.setBounds(149, 302, 129, 47);
		dd.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Calibri", Font.BOLD, 20));
		txtAmount.setColumns(10);
		txtAmount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAmount.setBounds(294, 310, 257, 35);
		dd.add(txtAmount);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Consolas", Font.BOLD, 28));
		lblName.setBounds(183, 194, 95, 39);
		dd.add(lblName);
		
		txtName = new JTextField();
		txtName.setToolTipText("name of customer who apply for dd");
		txtName.setFont(new Font("Calibri", Font.BOLD, 20));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(294, 194, 257, 35);
		dd.add(txtName);
		setVisible(true);
	}
	public void issue()
	{
		
		int index = Search.searchId(txtAccountNumber.getText().trim());
		try
		{
		if(index >=0)
		{
			ArrayList<CustomerDetails> userlist =new ArrayList<CustomerDetails>();
			userlist = CustomerDetailsFile.readDataFromFile();
			userlist.get(index).setBalance(userlist.get(index).getBalance() - Double.parseDouble(txtAmount.getText().trim())-25.00 );
			 TransactionSummary ts = new TransactionSummary();
			 ts.setAccNo(userlist.get(index).getAccountNo());
	        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	     	 LocalDateTime now = LocalDateTime.now();
	        	 ts.setDateAndTime(dtf.format(now));
	        	 ts.setWithdrawal(Double.parseDouble(txtAmount.getText().trim())+25.00 );
	        	 ts.setDeposite(0.0);
	        	 ts.setBalance(userlist.get(index).getBalance());
	        	 JOptionPane.showMessageDialog(this, "Demand draft of amount "+txtAmount.getText().trim()+ " is issued");
	        	 
	        	 ArrayList<TransactionSummary> trans = new ArrayList<TransactionSummary>();
	        	 
	        	 trans =  TransactionDetailsFile.readDataFromFile();
	        	 trans.add(ts);
	        	 
	        	 TransactionDetailsFile.writeDatatoFile(trans);
	        	 
	        	 String message = "Thank you for using Bank India International , \n"+txtAmount.getText().trim()+" Rupees is debited from your account \n";
				 
	        	 message = message+userlist.get(index).getAccountNo() + " Your current balance is "+userlist.get(index).getBalance()+" Rupees";
	        	 
	        	 EmailValid obj=new EmailValid();
					obj.Email(message,userlist.get(index).getAccountNo());
	     	 
	     	 CustomerDetailsFile.writeDatatoFile(userlist);
		}
		else
			JOptionPane.showMessageDialog(this,"Invalid Account number");
		}
		catch(Exception a)
		{
			JOptionPane.showMessageDialog(this, "Invalid details");
		}
		
	}
}
