package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.FileHandling.TransactionDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;
import com.BankingManagementSystem.Pojo.TransactionSummary;
import com.BankingManagementSystem.ValidationChecking.EmailValid;

public class TransferFrame {
	
	JLabel labelAccNo;
	ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
	private int senIndex,recIndex;
	private JTextField tRecAcc;
	private JTextField tAmount;
	private  JPanel contentPane;
	private JLabel labelName,labelAmount,lblSendersName,label_1 ,lblMoney;
	private JButton bmanager;
	
	
	
	
	 public TransferFrame(int index){
	        JFrame frame = new JFrame("FUND TRANSFER");
	        
	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        senIndex = index;
	        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        frame.setResizable(false);
	        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginPage.class.getResource("/resources/transfer.png")));
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    int result = JOptionPane.showConfirmDialog(
                            frame, "Are you sure?");
                    if( result==JOptionPane.OK_OPTION){
                        // NOW we change it to dispose on close..
                        frame.setDefaultCloseOperation(
                                JFrame.DISPOSE_ON_CLOSE);
                        frame.setVisible(false);
                        frame.dispose();
                        new TransactionFrame(null);
                    }
                }
            });
           
	        
            contentPane = new JPanel();
            contentPane.setOpaque(true);
            contentPane.setBackground(Color.WHITE);
            contentPane.setLayout(null);
            //CustomerDetails customerDetails = new CustomerDetails();
            labelName = new JLabel(userlist.get(senIndex).getCname(), JLabel.CENTER);
            labelName.setToolTipText("Sender's Name");
            Font f1=new Font("comic sans ms",Font.BOLD,30);
            labelName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            labelName.setForeground(new Color(0, 128, 0));
            labelName.setSize(307,42);
            labelName.setLocation(280,307);
            contentPane.add(labelName);
	        //ArrayList<CustomerDetails> list = new ArrayList<CustomerDetails>();
            labelAccNo = new JLabel(userlist.get(senIndex).getAccountNo(), JLabel.CENTER);
            labelAccNo.setToolTipText("Sender's Account Number");
            Font f2=new Font("comic sans ms",Font.BOLD,30);
            labelAccNo.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            labelAccNo.setForeground(new Color(34, 139, 34));
            labelAccNo.setSize(307,50);
            labelAccNo.setLocation(280,233);
            contentPane.add(labelAccNo);
            
           labelAmount = new JLabel("Amount :", JLabel.CENTER);
            Font f3=new Font("comic sans ms",Font.BOLD,30);
            labelAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            labelAmount.setForeground(Color.RED);
            labelAmount.setSize(180,50);
            labelAmount.setLocation(90,445);
            contentPane.add(labelAmount);
            
            
            tAmount = new JTextField();
            tAmount.setToolTipText("Enter Amount To Be Transfer");
            Font f5=new Font("comic sans ms",Font.BOLD,30);
            tAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            tAmount.setSize(307,42);
            tAmount.setLocation(280,449);
            contentPane.add(tAmount);
            

            JLabel labelReceiverAcc = new JLabel("Receiver Account :", JLabel.CENTER);
            Font f4=new Font("comic sans ms",Font.BOLD,28);
            labelReceiverAcc.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            labelReceiverAcc.setForeground(Color.RED);
            labelReceiverAcc.setSize(250,57);
            labelReceiverAcc.setLocation(10,369);
            contentPane.add(labelReceiverAcc);
            
            
            tRecAcc = new JTextField();
            tRecAcc.setToolTipText("Enter Reciever's Account Number");
            Font f6=new Font("comic sans ms",Font.BOLD,30);
            tRecAcc.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            tRecAcc.setSize(307,42);
            tRecAcc.setLocation(280,376);
            contentPane.add(tRecAcc);
            
             bmanager = new JButton("Transfer");
            //bmanager.setToolTipText("Confirm");
            bmanager.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
            Font f7=new Font("comic sans ms",Font.BOLD,22);
            bmanager.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
            bmanager.setForeground(new Color(220, 20, 60));
            bmanager.setSize(200,80);
            bmanager.setLocation(387,543);
            bmanager.setFocusable(false);
            contentPane.add(bmanager);
            bmanager.addActionListener(new ActionListener() 
	        {
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					try{
						    recIndex = Search.searchId(tRecAcc.getText().trim());
						    if(recIndex >= 0)
				         {
								if((tRecAcc.getText().trim()).equals(userlist.get(senIndex).getAccountNo()))
								{
					        		 JOptionPane.showMessageDialog(tAmount, "Invalid Receiver Account number");
								}
					        	 else{
						        		 	int amt=Integer.parseInt(tAmount.getText().trim());
						        		 	if(amt > 0)
						        		 	{
										 
								        		 int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
												if( result==JOptionPane.OK_OPTION)
												{
					                    	
													transferMoney();
													tRecAcc.setText("");
													tAmount.setText("");
													
													//EmailValid obj=new EmailValid();
													//obj.Email(userlist.get(senIndex).getAccountNo());
												/*
													frame.setVisible(false);
													TransactionFrame ob = new TransactionFrame(null);
													ob.setVisible(true);
													*/
												}
						        		 	}
						        		 	else
						        		 		JOptionPane.showMessageDialog(null, "Please enter a valid amount");
					        	     }
				         			}
						    
								 else
						         {
						            JOptionPane.showMessageDialog(tAmount, "Invalid Account number");
						         }
				 
                    	
				    }catch (Exception y) {
				    	JOptionPane.showMessageDialog(null, "Invalid input");
					}
				}
					
	        });
	        
           lblSendersName = new JLabel("Name :", SwingConstants.CENTER);
            lblSendersName.setForeground(Color.RED);
            lblSendersName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            lblSendersName.setBounds(116, 303, 158, 50);
            contentPane.add(lblSendersName);
            
           label_1 = new JLabel("Account No. :", SwingConstants.CENTER);
            label_1.setForeground(Color.RED);
            label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            label_1.setBounds(10, 233, 250, 57);
            contentPane.add(label_1);
            
           lblMoney = new JLabel("MONEY TRANSFER", SwingConstants.CENTER);
            lblMoney.setForeground(new Color(47, 79, 79));
            lblMoney.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            lblMoney.setBounds(28, 11, 559, 50);
            contentPane.add(lblMoney);
            frame.add(contentPane);
            frame.setSize(650,700);
            frame.setLocationByPlatform(false);
            frame.setVisible(true);
	    }

	 
	 public TransferFrame(){}

	 public void transferMoney()
	        {
		        	 userlist.get(senIndex).setBalance(userlist.get(senIndex).getBalance() - Double.parseDouble(tAmount.getText().trim()) );
		        	 userlist.get(recIndex).setBalance(userlist.get(recIndex).getBalance() + Double.parseDouble(tAmount.getText().trim()) );
		        	 
		        	 TransactionSummary ts = new TransactionSummary();
		           	 ts.setAccNo(userlist.get(recIndex).getAccountNo());
		           	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		        	 LocalDateTime now = LocalDateTime.now();
		           	 ts.setDateAndTime(dtf.format(now));
		           	 ts.setDeposite(Double.parseDouble(tAmount.getText().trim()));
		           	 ts.setWithdrawal(0.0);
		           	 ts.setBalance(userlist.get(recIndex).getBalance());
		           	 ArrayList<TransactionSummary> trans = new ArrayList<TransactionSummary>();
		           	 
		           	 trans =  TransactionDetailsFile.readDataFromFile();
		           	 trans.add(ts);
		           	 
		           	 TransactionDetailsFile.writeDatatoFile(trans);
		           	 
		           	 
		           	TransactionSummary ts1 = new TransactionSummary();
		          	 ts1.setAccNo(userlist.get(senIndex).getAccountNo());
		          	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		       	    LocalDateTime now1 = LocalDateTime.now();
		          	 ts1.setDateAndTime(dtf1.format(now1));
		          	 ts1.setWithdrawal(Double.parseDouble(tAmount.getText().trim()));
		          	 ts1.setDeposite(0.0);
		          	ts1.setBalance(userlist.get(senIndex).getBalance());
		          	 ArrayList<TransactionSummary> trans1 = new ArrayList<TransactionSummary>();
		          	 
		          	 trans1 =  TransactionDetailsFile.readDataFromFile();
		          	 trans1.add(ts);
		          	 
		          	 TransactionDetailsFile.writeDatatoFile(trans1);
		           	 
		           	 
		        	 CustomerDetailsFile.writeDatatoFile(userlist);
		        	 
		            String message = "Thank you for using Bank India International , \n "+tAmount.getText().trim()+" Rupees is debited from your account \n";
					 
		        	 message = message+userlist.get(senIndex).getAccountNo() + " Your current balance is "+userlist.get(senIndex).getBalance()+" Rupees";
		        	 
		        	 EmailValid obj=new EmailValid();
						obj.Email(message,userlist.get(senIndex).getAccountNo());
		        	 
		        	 JOptionPane.showMessageDialog(tAmount, "Transfer complete");
        	 
        
	    }

}
