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
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

public class ChequeBook extends JFrame
{

	private JPanel cheque;
	private JLabel lblNumberOfPages;
	private JLabel lblName;
	private JLabel lblAccountNumber;
	private JLabel lblChequeBookIssue;
	private JTextField txtName;
	private JTextField txtAccountNumber;
	private JButton btnIssue;
	private JComboBox cbPages;

	private String str[] = {"25","50","75","100"};
	private String noOfPages;

	/*public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ChequeBook frame = new ChequeBook();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	
	public ChequeBook() 
	{
		setTitle("CHEQUE BOOK");
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	setVisible(false);
            	dispose();
                    
                }
        }
        );

		setBounds(100, 100, 600, 500);
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/writing-cheque.png")));
		cheque = new JPanel();
		cheque.setBackground(new Color(135, 206, 250));
		cheque.setForeground(new Color(135, 206, 250));
		cheque.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cheque);
		cheque.setLayout(null);
		
		lblChequeBookIssue = new JLabel("CHEQUE BOOK ISSUE");
		lblChequeBookIssue.setForeground(Color.RED);
		lblChequeBookIssue.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblChequeBookIssue.setBounds(33, 11, 518, 61);
		cheque.add(lblChequeBookIssue);
		
		lblAccountNumber = new JLabel("ACCOUNT NUMBER :");
		lblAccountNumber.setFont(new Font("Consolas", Font.BOLD, 28));
		lblAccountNumber.setBounds(33, 136, 245, 47);
		cheque.add(lblAccountNumber);
		
		lblNumberOfPages = new JLabel("NUMBER OF PAGES:");
		lblNumberOfPages.setFont(new Font("Consolas", Font.BOLD, 28));
		lblNumberOfPages.setBounds(33, 252, 245, 47);
		cheque.add(lblNumberOfPages);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Consolas", Font.BOLD, 28));
		lblName.setBounds(183, 194, 101, 47);
		cheque.add(lblName);
		
	
		cbPages = new JComboBox(str);
		cbPages.setFont(new Font("Calibri", Font.BOLD, 20));
		cbPages.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbPages.setBounds(288, 259, 263, 29);
		cheque.add(cbPages);
		
		
		
		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.BOLD, 20));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(294, 194, 257, 35);
		cheque.add(txtName);
		txtName.setColumns(10);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setFont(new Font("Calibri", Font.BOLD, 20));
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAccountNumber.setBounds(294, 136, 257, 35);
		cheque.add(txtAccountNumber);
		
		btnIssue = new JButton("ISSUE");
		btnIssue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnIssue.setForeground(new Color(139, 0, 0));
		btnIssue.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnIssue.setBackground(new Color(106, 90, 205));
		btnIssue.setBounds(409, 337, 142, 61);
		cheque.add(btnIssue);
		btnIssue.addActionListener((e)->
		{
			issue();
			
			txtAccountNumber.setText("");
			txtName.setText("");
			
		});
		setVisible(true);
	}
	public void issue()
	{
		
	  int index = Search.searchId(txtAccountNumber.getText().trim());
	  
	  noOfPages = (String) cbPages.getSelectedItem();
	  if(index >= 0)
	  {
		  ArrayList<CustomerDetails> userlist =new ArrayList<CustomerDetails>();
		  userlist = CustomerDetailsFile.readDataFromFile();
		  userlist.get(index).setBalance(userlist.get(index).getBalance() - Double.parseDouble(noOfPages)*2.50 );
		  TransactionSummary ts = new TransactionSummary();
		  ts.setAccNo(userlist.get(index).getAccountNo());
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
     	    LocalDateTime now = LocalDateTime.now();
        	 ts.setDateAndTime(dtf.format(now));
        	 ts.setWithdrawal(Double.parseDouble(noOfPages)*2.50 );
        	 ts.setDeposite(0.0);
        	 ts.setBalance(userlist.get(index).getBalance());
        	 ArrayList<TransactionSummary> trans = new ArrayList<TransactionSummary>();
        	 JOptionPane.showMessageDialog(this, "Check Book issued");
        	 
        	 trans =  TransactionDetailsFile.readDataFromFile();
        	 trans.add(ts);
        	 
        	 TransactionDetailsFile.writeDatatoFile(trans);
        	 
             String message = "Thank you for using Bank India International , \n"+(Double.parseDouble(noOfPages)*2.50 )+" Rupees is debited from your account \n";
			 
        	 message = message+userlist.get(index).getAccountNo() + " Your current balance is "+userlist.get(index).getBalance()+" Rupees";
        	 
        	 EmailValid obj=new EmailValid();
				obj.Email(message,userlist.get(index).getAccountNo());
        	 
     	 
     	 CustomerDetailsFile.writeDatatoFile(userlist);
	  }
	  else
		  JOptionPane.showMessageDialog(this,"Invalid Account number");
	}
	/* public void withdrawMoney() {
		 if(accNo >= 0)
         {
        	 
        	 userlist.get(accNo).setBalance(userlist.get(accNo).getBalance() - Double.parseDouble(tdel.getText().trim()) );
        	 
        	 TransactionSummary ts = new TransactionSummary();
           	 ts.setAccNo(userlist.get(accNo).getAccountNo());
           	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        	 LocalDateTime now = LocalDateTime.now();
           	 ts.setDateAndTime(dtf.format(now));
           	 ts.setWithdrawal(Double.parseDouble(tdel.getText().trim()));
           	 ts.setDeposite(0.0);
           	 
           	 ArrayList<TransactionSummary> trans = new ArrayList<TransactionSummary>();
           	 
           	 trans =  TransactionDetailsFile.readDataFromFile();
           	 trans.add(ts);
           	 
           	 TransactionDetailsFile.writeDatatoFile(trans);
           	 
        	 
        	 CustomerDetailsFile.writeDatatoFile(userlist);
        	 
        	 JOptionPane.showMessageDialog(tdel, "withdrawal complete");
         }
         else
         {
            JOptionPane.showMessageDialog(tdel, "Invalid Account number");
         }
			
		}*/
}
