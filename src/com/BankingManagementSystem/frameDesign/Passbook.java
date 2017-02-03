package com.BankingManagementSystem.frameDesign;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.FileHandling.TransactionDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;
import com.BankingManagementSystem.Pojo.TransactionSummary;
import com.BankingManagementSystem.frameDesign.*;

public class Passbook extends JFrame
{
	private JPanel PassbookAndCheque;
	private JTextField txtAccountNumber;
	private JTextField txtCustomerName;
	private JButton btnNewButton,btnNewBUttonPrint ;
	int index1;
	ArrayList<CustomerDetails> userlist = new ArrayList<CustomerDetails>();
	
	ArrayList<TransactionSummary> transtemp = new ArrayList<TransactionSummary>();
	public Passbook()
	{
	
		//ManagerLoginPage obj=new ManagerLoginPage();
		
		setResizable(false);
		setTitle("Passbook");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginPage.class.getResource("/resources/passbook.png")));
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
               // if( result==JOptionPane.OK_OPTION){
                    // NOW we change it to dispose on close..
            	 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	 	setVisible(false);
            	 	dispose();
                	//new Managerframe(index);
                }
        }
        );
        
        
		setBounds(100, 100, 600, 500);
		PassbookAndCheque = new JPanel();
		PassbookAndCheque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PassbookAndCheque.setBackground(new Color(240, 255, 240));
		PassbookAndCheque.setName("Passbook And Cheque");
		PassbookAndCheque.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(PassbookAndCheque);
		PassbookAndCheque.setLayout(null);
		
		JLabel lblPassbookAndCheque = new JLabel("PRINTING AND ISSUEING A PASSBOOK");
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
		
		 btnNewButton = new JButton("DETAILS");
		btnNewButton.setToolTipText("shows the deatails of customer");
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(396, 336, 170, 55);
		PassbookAndCheque.add(btnNewButton);
		
		btnNewButton.addActionListener((e)->
		{
			printDetails();
		});
		
		

		 btnNewBUttonPrint = new JButton("TRANSACTION");
		 btnNewBUttonPrint.setToolTipText("print the transaction history");
		 btnNewBUttonPrint.setBackground(new Color(218, 165, 32));
		 btnNewBUttonPrint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 btnNewBUttonPrint.setFont(new Font("Times New Roman", Font.BOLD, 26));
		 btnNewBUttonPrint.setBounds(96, 336, 220, 55);
		PassbookAndCheque.add(btnNewBUttonPrint);
		
		btnNewBUttonPrint.addActionListener((e)->
		{
			printPassbook();
		});
		
		 
		 setVisible(true);
	}
	public void printDetails()
	{
		try{
		
		userlist = CustomerDetailsFile.readDataFromFile();
		index1=Search.searchId(txtAccountNumber.getText().trim());
		ArrayList<CustomerDetails> userlisttemp = new ArrayList<CustomerDetails>();
		userlisttemp.add(userlist.get(index1));
		//JOptionPane.showMessageDialog(this, "hey");
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					new ShowCustomerDetails(userlisttemp);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Invalid Account number");
		}
		
	}
	public void printPassbook()
	{
		
		ArrayList<TransactionSummary> trans =new  ArrayList<TransactionSummary>();
		trans = TransactionDetailsFile.readDataFromFile();
		for(TransactionSummary re : trans)
		{
			if((txtAccountNumber.getText().trim()).equals(re.getAccNo()))
			transtemp.add(re);
				
		}
		new PrintPassbook(transtemp);
		
	}
	
	
	
}

/*public class PassbookAndCheque 
{

	public static void main(String[] args) 
	{
		

	}

}*/
