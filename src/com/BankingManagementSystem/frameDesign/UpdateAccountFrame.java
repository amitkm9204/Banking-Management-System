package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;
import com.BankingManagementSystem.ValidationChecking.Validation;

public class UpdateAccountFrame extends JFrame
{
	private JTextField taccno,tphn, tname;
	private JTextArea tadd;
	private JFrame frame ;
	private JPanel contentPane;
	private JLabel label ,label1,label2,label3,lblNewLabel  ;
	private JScrollPane taddsp;
	private JButton bdel;
	boolean isdatavalidate;
	
    public UpdateAccountFrame()
    {
    	frame = new JFrame("UPDATE INFORMATIONS");
    	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginPage.class.getResource("/resources/update.png")));
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
               // if( result==JOptionPane.OK_OPTION){
                    // NOW we change it to dispose on close..
            	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	 frame.setVisible(false);
            	 frame.dispose();
                   // new AccountantFrame();
                }
        }
        );
        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setLayout(null);
        
        
        label = new JLabel("ACCOUNT NO : ", JLabel.CENTER);
        label.setToolTipText("Account Number Can't Be Change");
        Font f1=new Font("comic sans ms",Font.BOLD,22);
        label.setFont(f1);
        label.setForeground(Color.RED);
        label.setSize(187,32);
        label.setLocation(65,129);
        contentPane.add(label);
        
        label1 = new JLabel("NAME : ", JLabel.CENTER);
        label1.setToolTipText("Name Can't Be Change");
        label1.setFont(f1);
        label1.setForeground(Color.RED);
        label1.setSize(97,32);
        label1.setLocation(155,211);
        contentPane.add(label1);
        
        
        label2 = new JLabel("ADDRESS : ", JLabel.CENTER);
        label2.setFont(f1);
        label2.setForeground(Color.RED);
        label2.setSize(136,32);
        label2.setLocation(116,294);
        contentPane.add(label2);
        
        
        label3 = new JLabel("PHONE NO : ", JLabel.CENTER);
        label3.setFont(f1);
        label3.setForeground(Color.RED);
        label3.setSize(155,40);
        label3.setLocation(97,352);
        contentPane.add(label3);
        
        
         taccno = new JTextField(20);
        taccno.setToolTipText("Enter Your Account Number");
        taccno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Font f3=new Font("consolas",Font.ITALIC,20);
        taccno.setFont(new Font("Consolas", Font.BOLD, 24));
        taccno.setSize(347,40);
        taccno.setLocation(280,129);
        contentPane.add(taccno);
        
        tname = new JTextField(20);
        tname.setToolTipText("Enter Your Name ");
        tname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        tname.setFont(new Font("Consolas", Font.BOLD, 24));
        tname.setSize(347,40);
        tname.setLocation(280,211);
        contentPane.add(tname);
        
         tadd=new JTextArea(5,20);
        tadd.setToolTipText("Enter New Address");
        tadd.setFont(new Font("Consolas", Font.BOLD, 24));
        tadd.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
        taddsp=new JScrollPane(tadd);
		Font f4=new Font("consolas",Font.ITALIC,20);
        taddsp.setFont(f4);
        taddsp.setSize(347,40);
        taddsp.setLocation(280,286);
        contentPane.add(taddsp);
        
        tphn = new JTextField(20);
        tphn.setToolTipText("Enter New Phone Number");
        tphn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        tphn.setFont(new Font("Consolas", Font.BOLD, 24));
        tphn.setSize(347,40);
        tphn.setLocation(280,356);
        contentPane.add(tphn);
        
        
        
        
        bdel = new JButton("UPDATE");
        bdel.setToolTipText("Update Information");
        bdel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bdel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        bdel.setForeground(new Color(220, 20, 60));
        bdel.setSize(200,80);
        bdel.setLocation(427,438);
        bdel.setFocusable(true);
        contentPane.add(bdel);
        
        bdel.addActionListener((e)->
        {
        	updateAccount();
        });

        frame.setContentPane(contentPane);
        
        lblNewLabel = new JLabel("UPDATE DETAILS");
        lblNewLabel.setForeground(new Color(34, 139, 34));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblNewLabel.setBounds(226, 11, 361, 50);
        contentPane.add(lblNewLabel);
        frame.setSize(800,600);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
        frame.setResizable(false);
        
       
    }

    public void updateAccount()
    {
    	try{
    				int idfoundpos = Search.searchId(taccno.getText().trim());
    				ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
    				if((tname.getText().trim()).equals(userlist.get(idfoundpos).getCname()))
    				{
    					JOptionPane.showMessageDialog(this, "Invalid Name");
    				}
    				else if(idfoundpos >= 0 )
    				{
    					String phone=tphn.getText().trim();
    		    		isdatavalidate = phoneCheck(phone);
    		    		if(isdatavalidate)
    		    			{
    					
    					userlist.get(idfoundpos).setCaddress(tadd.getText().trim());
    					userlist.get(idfoundpos).setCphone(tphn.getText().trim());
       	 
    					CustomerDetailsFile.writeDatatoFile(userlist);
    					JOptionPane.showMessageDialog(this, "Account updation successfull");
    		    			}
       	 
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(this, "Invalid Account number");
    				}
    			
    	}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Invalid input data");
		}
   
    }
    public boolean phoneCheck(String Phone)
    {
    	String phonePattern = "^[0-9]{10}$";
    	
    	Scanner sc3 = new Scanner(Phone);
    	
    	String match2 = sc3.findInLine(phonePattern);
    	
    	if (match2 == null)
    	{
    		JOptionPane.showMessageDialog(null, "Invalid Phone Number..");
    		return false;
    	}
    	
    	else
    		return true;
    }
   /* public static void main(String... args)
    {
              new UpdateAccountFrame();
    }*/
}