package com.BankingManagementSystem.frameDesign;

import com.BankingManagementSystem.Pojo.*;
import com.BankingManagementSystem.FileHandling.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.function.ToDoubleFunction;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.ws.RespectBindingFeature;

import com.BankingManagementSystem.Pojo.CustomerDetails;

public class DepositeFrame extends JFrame
{
	
	ArrayList<CustomerDetails> userlist;
	CustomerDetails r;
	JTextField tdel;
	int accNO;
    public DepositeFrame(int index) {
    	
    	accNO = index;
    	try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
    	
    	
        JFrame frame = new JFrame("Deposite");
        
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        JLabel labelAccNo = new JLabel("Acc02233", JLabel.CENTER);
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
        labelAmount.setLocation(0,205);
        contentPane.add(labelAmount);
        
        
         tdel = new JTextField();
        Font f5=new Font("comic sans ms",Font.ITALIC,18);
        tdel.setFont(f5);
        tdel.setSize(250,50);
        tdel.setLocation(295,265);
        contentPane.add(tdel);
        
        JButton bmanager = new JButton("Confirm");
        Font f4=new Font("comic sans ms",Font.BOLD,22);
        bmanager.setFont(f4);
        bmanager.setForeground(Color.BLUE);
        bmanager.setSize(200,80);
        bmanager.setLocation(200,500);
        bmanager.setFocusable(false);
        contentPane.add(bmanager);
        
        bmanager.addActionListener((e)->
        {
        	depositmoney();
        });
        
        
        
        /*
        bmanager.addActionListener(new ActionListener() 
        {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(
                        frame, "Are you sure?");
                if( result==JOptionPane.OK_OPTION)
                {
                	
                	  userlist = CustomerDetailsFile.readDataFromFile();
                	  r.setBalance(Double.parseDouble(tdel.getText().trim()));
                	  userlist.add(r);
				      
				      CustomerDetailsFile.writeDatatoFile(userlist);
				      JOptionPane.showInputDialog(this, "Amount Deposited");
				    
				      resetFrame();
				
			    }
                	
		   }
        }
			
        							);
        							*/
        
 

        frame.setContentPane(contentPane);
        frame.setSize(600,700);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
    }

public void depositmoney() {
		
	if(accNO >= 0)
    {
   	 ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
   	 userlist.get(accNO).setBalance(userlist.get(accNO).getBalance() + Double.parseDouble(tdel.getText().trim()) );		 
   	 CustomerDetailsFile.writeDatatoFile(userlist);
   	 
   	 JOptionPane.showInputDialog(this, "Transfer complete");
    }
    else
    {
       JOptionPane.showInputDialog(this, "Invalid Account number");
    }
		
	}


	/*public void resetFrame()
    {
   	 this.dispose();
   	 new DepositeFrame();
    }
    
    
    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DepositeFrame();
            }
        });
    }*/
}
