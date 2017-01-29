package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;

public class TransferFrame {
	
	JLabel labelAccNo;
	int senIndex,recIndex;
	JTextField tRecAcc;
	JTextField tAmount;
	 public TransferFrame(int index){
	        JFrame frame = new JFrame("Deposite");
	        
	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        senIndex = index;
	        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      
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
           
	        
	        JPanel contentPane = new JPanel();
	        contentPane.setOpaque(true);
	        contentPane.setBackground(new Color(76, 224, 230));
	        contentPane.setLayout(null);
	        CustomerDetails customerDetails = new CustomerDetails();
	        JLabel labelName = new JLabel(customerDetails.getCname(), JLabel.CENTER);
	        Font f1=new Font("comic sans ms",Font.BOLD,48);
	        labelName.setFont(f1);
	        labelName.setForeground(Color.RED);
	        labelName.setSize(300,150);
	        labelName.setLocation(105,5);
	        contentPane.add(labelName);
	        
	         labelAccNo = new JLabel("Acc02233", JLabel.CENTER);
	        Font f2=new Font("comic sans ms",Font.BOLD,48);
	        labelAccNo.setFont(f2);
	        labelAccNo.setForeground(Color.RED);
	        labelAccNo.setSize(300,150);
	        labelAccNo.setLocation(155,105);
	        contentPane.add(labelAccNo);
	        
	        JLabel labelAmount = new JLabel("Amount", JLabel.CENTER);
	        Font f3=new Font("comic sans ms",Font.BOLD,48);
	        labelAmount.setFont(f3);
	        labelAmount.setForeground(Color.RED);
	        labelAmount.setSize(300,150);
	        labelAmount.setLocation(0,305);
	        contentPane.add(labelAmount);
	        
	        
	         tAmount = new JTextField();
	        Font f5=new Font("comic sans ms",Font.ITALIC,18);
	        tAmount.setFont(f5);
	        tAmount.setSize(250,50);
	        tAmount.setLocation(295,365);
	        contentPane.add(tAmount);
	        

	        JLabel labelReceiverAcc = new JLabel("Account No.", JLabel.CENTER);
	        Font f4=new Font("comic sans ms",Font.BOLD,48);
	        labelReceiverAcc.setFont(f4);
	        labelReceiverAcc.setForeground(Color.RED);
	        labelReceiverAcc.setSize(300,150);
	        labelReceiverAcc.setLocation(0,205);
	        contentPane.add(labelReceiverAcc);
	        
	        
	         tRecAcc = new JTextField();
	        Font f6=new Font("comic sans ms",Font.ITALIC,18);
	        tRecAcc.setFont(f6);
	        tRecAcc.setSize(250,50);
	        tRecAcc.setLocation(295,265);
	        contentPane.add(tRecAcc);
	        
	        JButton bmanager = new JButton("Confirm");
	        Font f7=new Font("comic sans ms",Font.BOLD,22);
	        bmanager.setFont(f7);
	        bmanager.setForeground(Color.BLUE);
	        bmanager.setSize(200,80);
	        bmanager.setLocation(200,500);
	        bmanager.setFocusable(false);
	        contentPane.add(bmanager);
	        bmanager.addActionListener(new ActionListener() 
	        {
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					int result = JOptionPane.showConfirmDialog(
                            frame, "Are you sure?");
                    if( result==JOptionPane.OK_OPTION)
                    {
                        transferMoney();
					
				    }
			   }
	        }
				
	        							);
	        
	 

	        frame.setContentPane(contentPane);
	        frame.setSize(600,700);
	        frame.setLocationByPlatform(false);
	        frame.setVisible(true);
	    }

	 
	 public TransferFrame(){}

	 public void transferMoney()
	 {
		 recIndex = Search.searchId(tRecAcc.getText().trim());
		 if(recIndex >= 0)
         {
        	 ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
        	 userlist.get(senIndex).setBalance(userlist.get(senIndex).getBalance() - Double.parseDouble(tAmount.getText().trim()) );
        	 userlist.get(recIndex).setBalance(userlist.get(recIndex).getBalance() + Double.parseDouble(tAmount.getText().trim()) );		 
        	 CustomerDetailsFile.writeDatatoFile(userlist);
        	 
        	 JOptionPane.showInputDialog(this, "Transfer complete");
         }
         else
         {
            JOptionPane.showInputDialog(this, "Invalid Account number");
         }
	 }

}
