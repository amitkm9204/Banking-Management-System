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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import com.BankingManagementSystem.FileHandling.ManagerDetailsFile;
import com.BankingManagementSystem.FileHandling.TransactionDetailsFile;
import com.BankingManagementSystem.Pojo.ManagerDetails;
import com.BankingManagementSystem.Pojo.TransactionSummary;

public class Managerframe extends JFrame
{
	private JLabel label;
	private JPanel contentPane;
	private JFrame frame;
	private JButton bpassBook,bcheckBook,bDraft;
	private JButton btransSummary;
	private JButton bCustomerInfo,btnLogOut,btnChangePassword;
	private JButton bAccountantInfo;
	private JLabel lblManagerName ;
	private JLabel lblNewLabel;
	
	static int mng;
	

	ArrayList<ManagerDetails> managerlist = new ArrayList<ManagerDetails>();
	ArrayList<TransactionSummary>  transactionlist;
	int ManagerIndex;
      public Managerframe(int index)
      {
    	  
  		
    	  ManagerIndex = index;
    	  mng=ManagerIndex;
    	  managerlist = ManagerDetailsFile.readDataFromFile();
    	  setResizable(false);
  		setTitle("MANAGER");
  		setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/customer-service.png")));
        
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e) 
            {

            	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            	 int result = JOptionPane.showConfirmDialog(null, "You will be logged out\nAre you sure ?");
                if( result==JOptionPane.OK_OPTION)
                {
                	
             	   setVisible(false);
             	  //start.flagmng=false;
             	   dispose();
             	
                 }
            }
            
         }
         );
        
 		
        contentPane = new JPanel();
        contentPane.setOpaque(true);
        
        contentPane.setBackground(new Color(245, 222, 179));
        contentPane.setLocation(100, 100);
        contentPane.setLayout(null);
      
       
        ManagerDetails managerDetails = new ManagerDetails();
       
        label = new JLabel(managerlist.get(index).getManagerName().toUpperCase(), JLabel.LEFT);
        label.setToolTipText("Manager's Name");
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        label.setForeground(new Color(0, 128, 0));
        label.setSize(355,43);
        label.setLocation(190,110);
       
        contentPane.add(label);
        
        
        bpassBook = new JButton("Passbook ");
        bpassBook.setToolTipText("Issue or printing a passbook");
        bpassBook.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
       
        Font f2=new Font("comic sans ms",Font.BOLD,22);
       
        bpassBook.setFont(f2);
        bpassBook.setForeground(new Color(160, 82, 45));
        bpassBook.setSize(160,60);
        bpassBook.setLocation(50,189);
        bpassBook.setFocusable(false);
        contentPane.add(bpassBook);
        
        bpassBook.addActionListener((e)->
        {
        	passbook();
        });
        
        bcheckBook = new JButton("Cheque Book ");
        bcheckBook.setToolTipText("Issue a check book");
        bcheckBook.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
       
        Font f3=new Font("comic sans ms",Font.BOLD,22);
       
        bcheckBook.setFont(f3);
        bcheckBook.setForeground(new Color(160, 82, 45));
        bcheckBook.setSize(220,60);
        bcheckBook.setLocation(255,189);
        bcheckBook.setFocusable(false);
        contentPane.add(bcheckBook);
        
        bcheckBook.addActionListener((e)->
        {
        	checkBook();
        });
        bDraft = new JButton("Draft ");
        bDraft.setToolTipText("Issue a Demand Draft");
        bDraft.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
       
        Font f4=new Font("comic sans ms",Font.BOLD,22);
       
        bDraft.setFont(f3);
        bDraft.setForeground(new Color(160, 82, 45));
        bDraft.setSize(140,60);
        bDraft.setLocation(520,189);
        bDraft.setFocusable(false);
        contentPane.add(bDraft);
        
        bDraft.addActionListener((e)->
        {
        	draft();
        });
        
        
        btransSummary = new JButton("Transaction summary");
        btransSummary.setToolTipText("All Transation Summary");
        btransSummary.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btransSummary.setFont(f2);
        btransSummary.setForeground(new Color(160, 82, 45));
        btransSummary.setSize(300,80);
        btransSummary.setLocation(210,291);
        btransSummary.setFocusable(false);
        contentPane.add(btransSummary);
        btransSummary.addActionListener((e)->
        {
        	transactionSummary();
        });
 
        bCustomerInfo = new JButton("Customer Information");
        bCustomerInfo.setToolTipText("Customer's details");
        bCustomerInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        bCustomerInfo.setFont(f2);
        bCustomerInfo.setForeground(new Color(160, 82, 45));
        bCustomerInfo.setSize(300,80);
        bCustomerInfo.setLocation(210,394);
        bCustomerInfo.setFocusable(false);
        contentPane.add(bCustomerInfo);
        bCustomerInfo.addActionListener((e)->
        {
        	customerInfo();
        });
       
        bAccountantInfo = new JButton("Accountant Information");
        bAccountantInfo.setToolTipText("Accountant's Details");
        bAccountantInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        bAccountantInfo.setFont(f2);
        bAccountantInfo.setForeground(new Color(160, 82, 45));
        bAccountantInfo.setSize(300,80);
        bAccountantInfo.setLocation(210,494);
        bAccountantInfo.setFocusable(false);
        contentPane.add(bAccountantInfo);
        bAccountantInfo.addActionListener((e)->
        {
        	accountantInfo();
        });

        lblManagerName = new JLabel("HELLO MR.", SwingConstants.LEFT);
        lblManagerName.setForeground(Color.RED);
        lblManagerName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblManagerName.setBounds(15, 110, 175, 43);
        contentPane.add(lblManagerName);
        
        lblNewLabel = new JLabel("MANAGER PANEL");
        lblNewLabel.setForeground(new Color(106, 90, 205));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblNewLabel.setBounds(150, 0, 364, 67);
        contentPane.add(lblNewLabel);
        
        
        
        btnLogOut = new JButton("Logout");
		//btnLogOut.setToolTipText("show account wise or all account");
		btnLogOut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogOut.setForeground(Color.BLUE);
		btnLogOut.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnLogOut.setBounds(545,110,120,40);
		contentPane.add(btnLogOut);
		
		
		btnLogOut.addActionListener((e)->
		{
			LogOut();
		});
		
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnChangePassword.setFont(f2);
		btnChangePassword.setForeground(new Color(160, 82, 45));
		btnChangePassword.setSize(300,80);
		btnChangePassword.setLocation(210,594);
		btnChangePassword.setFocusable(false);
        contentPane.add(btnChangePassword);
        
        
        btnChangePassword.addActionListener((e)->
		{
			ChangePassword();
		});
        
        setContentPane(contentPane);
        setSize(700,750);
        setLocationByPlatform(false);
        setVisible(true);
    }
      
      private void LogOut()
  	{
    	  EventQueue.invokeLater(new Runnable() 
    	  {
   			public void run() 
   			{
   				try
   				{
   					int x = JOptionPane.showConfirmDialog(null,"Are you sure ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
					if(x==JOptionPane.YES_OPTION)
					{
						start.flagmng=true;
						dispose();
					}   					
   				} 
   				catch (Exception e) 
   				{
   					e.printStackTrace();
   				}
   			}
   		});
  		
  	}
      public void ChangePassword() 
  	{
    	  EventQueue.invokeLater(new Runnable() {
     			public void run() {
     				try {
     					ArrayList<ManagerDetails> accDetails =new  ArrayList<ManagerDetails>();
     	              	accDetails =ManagerDetailsFile.readDataFromFile();
     	                  new ChangePassword(accDetails.get(ManagerIndex),ManagerIndex);
     					
     				} catch (Exception e) {
     					e.printStackTrace();
     				}
     			}
     		});
  		
  	}
      
      public void checkBook()
      {
    	  EventQueue.invokeLater(new Runnable() {
   			public void run() {
   				try {
   					  new ChequeBook();
   					
   				} catch (Exception e) {
   					e.printStackTrace();
   				}
   			}
   		});
      }
      public void passbook()
      {
    	  EventQueue.invokeLater(new Runnable() {
   			public void run() {
   				try {
   					  new Passbook();
   					
   				} catch (Exception e) {
   					e.printStackTrace();
   				}
   			}
   		});
      }
      public void accountantInfo()
      {
    	  EventQueue.invokeLater(new Runnable() {
  			public void run() {
  				try {
  					  new AccountantInformationFrame(ManagerIndex);
  					
  				} catch (Exception e) {
  					e.printStackTrace();
  				}
  			}
  		});
      }

      public void transactionSummary()
      {
    	  transactionlist = new ArrayList<TransactionSummary>();
    	  transactionlist = TransactionDetailsFile.readDataFromFile();
    	  EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					  new AllDetailsTransaction(transactionlist);
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
      }
     public void customerInfo()
      {
    	 EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					  new CustomerInformationFrame(ManagerIndex);
 					
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		});
      }
     public void draft()
     {
    	 EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					 new DemandDraft();
 					
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		}); 
     }
     /* public static void main(String... args)
      {
          SwingUtilities.invokeLater(new Runnable()
          {
              public void run()
              {
                  new Managerframe(2);
              }
          });
      }*/
}