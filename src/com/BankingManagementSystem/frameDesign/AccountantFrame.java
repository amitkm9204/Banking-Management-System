package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.BankingManagementSystem.FileHandling.AccountantDetailsFile;
import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.FileHandling.ManagerDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;
import com.BankingManagementSystem.Pojo.ManagerDetails;
import com.BankingManagementSystem.Pojo.AccountantDetails;

class AccountantFrame extends JFrame
{

	private JPanel accountantPage ;
	//private Panel DisplayPage;
	private JButton btnAddAccount;
	private JButton btnRemoveAccount;
	private JButton btnUpdateDetails,btnacc;
	private JButton btnTransaction;
	private JLabel lblViewDetals;
	private JLabel lblAccountantAccess;
	private JLabel label,lblaccountant;
	private JComboBox View;
	private JButton btnChangePassword,btnLogOut;
	
	static int acc;
	private int accIndex;
	
	
	ArrayList<AccountantDetails> accountantlist = new ArrayList<AccountantDetails>();
	
	
	
	public AccountantFrame(int a) 
	{
		/*try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}*/
		acc=a;
		accIndex=a;
		setResizable(false);
		setTitle("ACCOUNTANT");
		setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/call-center-operator.png")));
		
		
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
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
		
		
		
		accountantlist = AccountantDetailsFile.readDataFromFile();
		//JOptionPane.showMessageDialog(this,accountantlist.get(a).getAccountantName());
		
		AccountantDetails accDetails = new AccountantDetails();
		
		
		/*lblaccountant = new JLabel("HELLO MR. " + accountantlist.get(a).getAccountantName().toUpperCase(), JLabel.CENTER);
		lblaccountant.setToolTipText("Accountant's Name");
		lblaccountant.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblaccountant.setForeground(new Color(0, 128, 0));
		lblaccountant.setSize(269,43);
		lblaccountant.setLocation(190,110);
		accountantPage.add(lblaccountant);*/
        
        
        /*
        lblaccountant = new JLabel(accountantlist.get(index).getAccountantName().toUpperCase());
        lblaccountant.setToolTipText("ACCESS ACCOUNT");
        lblaccountant.setForeground(new Color(0, 20, 60));
        lblaccountant.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
        lblaccountant.setBounds(253, 150, 178, 40);
		accountantPage.add(lblaccountant);*/

        
     
        
       /* lblManagerName = new JLabel("HELLO MR.", JLabel.CENTER);
        lblManagerName.setForeground(Color.RED);
        lblManagerName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblManagerName.setBounds(30, 110, 246, 43);
        accountantPage.add(lblManagerName);*/
        
		
		setBounds(0,0, 700, 720);
		accountantPage = new JPanel();
		accountantPage .setBackground(new Color(255, 239, 213));
		accountantPage .setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(accountantPage );
		accountantPage .setLayout(null);
		
		btnAddAccount = new JButton("ADD ACCOUNT ");
		btnAddAccount.setToolTipText("REGISTER NEW ACCOUNT");
		btnAddAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddAccount.setForeground(new Color(0, 70, 60));
		btnAddAccount.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnAddAccount.setBounds(162,200,360,60);
		accountantPage.add(btnAddAccount);
		
		btnAddAccount.addActionListener((e)->
		{
			accountOpen();
		});
		
		btnRemoveAccount = new JButton("REMOVE ACCOUNT ");
		btnRemoveAccount.setToolTipText("REMOVE AN ACCOUNT");
		btnRemoveAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnRemoveAccount.setForeground(new Color(0, 20, 60));
		btnRemoveAccount.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnRemoveAccount.setBounds(162,270,360,60);
		accountantPage.add(btnRemoveAccount);
		
		btnRemoveAccount.addActionListener((e)->
		{
			accountRemove();
		});
		
		
		btnUpdateDetails = new JButton("UPDATE ACCOUNT ");
		btnUpdateDetails.setToolTipText("CHANGE ADDRESS AND PHONE NUMBER");
		btnUpdateDetails.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnUpdateDetails.setForeground(new Color(0, 20, 60));
		btnUpdateDetails.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnUpdateDetails.setBounds(162,340,360,60);
		accountantPage.add(btnUpdateDetails);
	
		btnUpdateDetails.addActionListener((e)->
		{
			accountUpdate();
		});
		
		btnTransaction = new JButton("TRANSACTION");
		btnTransaction.setToolTipText("FUND WITHDRAW, DEPOSITE AND TRANSFER");
		btnTransaction.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnTransaction.setForeground(new Color(0, 20, 60));
		btnTransaction.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnTransaction.setBounds(162,410,360,60);
		accountantPage.add(btnTransaction);
	
		btnTransaction.addActionListener((e)->
		{
			accountTransaction();
		});
		
		
		lblViewDetals = new JLabel("VIEW ACCOUNT:");
		lblViewDetals.setToolTipText("ACCESS ACCOUNT");
		lblViewDetals.setForeground(new Color(0, 20, 60));
		lblViewDetals.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		lblViewDetals.setBounds(253, 500, 178, 40);
		accountantPage.add(lblViewDetals);
		
		
		String str[] = {"Account wise","All Accounts"};
		
		View = new JComboBox(str);
		View.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		View.setBounds(162, 540, 360, 40);
		View.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		accountantPage.add(View);
		
		btnacc = new JButton("show");
		btnacc.setToolTipText("show account wise or all account");
		btnacc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnacc.setForeground(new Color(0, 20, 60));
		btnacc.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnacc.setBounds(530,540,100,40);
		accountantPage.add(btnacc);
		
		btnacc.addActionListener((e) ->
		                      {
		                    	  //System.out.println("hey tigetr");
		                    	  if(View.getSelectedItem().equals("Account wise"))
		                  		{
		                    		  //JOptionPane.showMessageDialog(this, "HI..");
		                  			openAccountWise();
		                  		}
		                  		else if(View.getSelectedItem().equals("All Accounts"))
		                  		{
		                  			//JOptionPane.showMessageDialog(this, "HIiiiiii..");
		                  			openAllAccount();
		                  		}
		                    	  
		                      }
				
				            );
		
		
			
		lblAccountantAccess = new JLabel("ACCOUNTANT PANEL");
		lblAccountantAccess.setForeground(new Color(139, 0, 139));
		lblAccountantAccess.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAccountantAccess.setBounds(128, 22, 467, 39);
		accountantPage.add(lblAccountantAccess);	
		
		
		
		lblaccountant = new JLabel(accountantlist.get(a).getAccountantName().toUpperCase(), JLabel.LEFT);
		lblaccountant.setToolTipText("Accountant's Name");
		lblaccountant.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblaccountant.setForeground(new Color(0, 128, 0));
		lblaccountant.setSize(350,43);
		lblaccountant.setLocation(190,110);
		accountantPage.add(lblaccountant);
		
		
		label = new JLabel("HELLO MR.", JLabel.LEFT);
		label.setForeground(Color.RED);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		label.setBounds(15, 110, 175, 43);
        accountantPage.add(label);
        
        
        btnLogOut = new JButton("Logout");
		//btnLogOut.setToolTipText("show account wise or all account");
		btnLogOut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogOut.setForeground(Color.BLUE);
		btnLogOut.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnLogOut.setBounds(550,110,120,40);
		accountantPage.add(btnLogOut);
		
		btnLogOut.addActionListener((e)->
		{
			LogOut();
		});
		
		
		btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.setToolTipText("CHANGE ADDRESS AND PHONE NUMBER");
		btnChangePassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnChangePassword.setForeground(new Color(0, 20, 60));
		btnChangePassword.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnChangePassword.setBounds(162,610,360,60);
		accountantPage.add(btnChangePassword);
		
		
		btnChangePassword.addActionListener((e)->
		{
			ChangePassword();
		});
		
		this.setVisible(true);
		
		setLocationByPlatform(false);
	
	}
	
private void LogOut()
	{
	
	 EventQueue.invokeLater(new Runnable() 
	  {
			public void run() 
			{
				try
				{
					 //setVisible(false);
					int x = JOptionPane.showConfirmDialog(null,"Are you sure ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
					if(x==JOptionPane.YES_OPTION)
					{
						start.flagacc=true;
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
  					ArrayList<AccountantDetails> accDetails =new  ArrayList<AccountantDetails>();
  	            	accDetails = AccountantDetailsFile.readDataFromFile();
  	                new ChangePassword(accDetails.get(accIndex),accIndex);
  					
  				} catch (Exception e) {
  					e.printStackTrace();
  				}
  			}
  		});
		
	}
	public void openAllAccount()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
            	ArrayList<CustomerDetails> costomer = new ArrayList<CustomerDetails>();
            	costomer = CustomerDetailsFile.readDataFromFile();
                new AllDetailsCustomer(costomer);
                
            }
        });
	}
	public void openAccountWise()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
            	
            	new CustomerAccountwiseFrame();
                
            }
        });
	}
	public void accountOpen()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new AccountOpening();
                
            }
        });
	}
	public void accountRemove()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DeleteAccountFrame();
                
            }
        });
	}
	public void accountUpdate()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new UpdateAccountFrame();
                
            }
        });
	}
	public void accountTransaction()
	{
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TransactionFrame("Transaction");
                
            }
        });
	}
}

/*public  class AccountantFrame
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Accountantform accountant = new Accountantform();
					accountant.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/




