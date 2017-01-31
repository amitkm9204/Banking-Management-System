package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class CustomerAccountwiseFrame extends JFrame
{
	private JTextField txtAcc;
	private JLabel label;
	private JButton bmanager;
	
	
    public CustomerAccountwiseFrame()
    {
    	formOpen();
    	
    }

    private void formOpen() 
    {
    		JFrame frame = new JFrame("CUSTOMER ACCOUNTWISE");
    		frame.setResizable(false);
		   
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel contentPane = new JPanel();
	        contentPane.setOpaque(true);
	        contentPane.setBackground(new Color(176, 224, 230));
	        contentPane.setLayout(null);
	        
	        
	        label=new JLabel("ACCOUNT NO : ", JLabel.CENTER);
	        Font f1=new Font("comic sans ms",Font.BOLD,26);
	        label.setFont(f1);
	        label.setForeground(Color.RED);
	        label.setSize(223,50);
	        label.setLocation(38,171);
	        contentPane.add(label);
	        
	        
	        txtAcc=new JTextField();
	        txtAcc.setToolTipText("ENTER ACCOUNT NUMBER");
	        txtAcc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        Font f3=new Font("comic sans ms",Font.ITALIC,18);
	        txtAcc.setFont(new Font("Consolas", Font.BOLD, 28));
	        txtAcc.setSize(356,50);
	        txtAcc.setLocation(271,175);
	        contentPane.add(txtAcc);
	        
	        
	        
	        bmanager=new JButton("SHOW DETAILS");
	        bmanager.setToolTipText("SHOW CUSTOMER DETAILS");
	        bmanager.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        Font f2=new Font("comic sans ms",Font.BOLD,22);
	        bmanager.setFont(f2);
	        bmanager.setForeground(new Color(199, 21, 133));
	        bmanager.setSize(223,64);
	        bmanager.setLocation(404,282);
	        bmanager.setFocusable(true);
	        contentPane.add(bmanager);
	        

	        frame.setContentPane(contentPane);
	        
	        JLabel lblNewLabel = new JLabel("PARTICULAR CUSTOMER'S INFORMATION");
	        lblNewLabel.setForeground(new Color(128, 0, 128));
	        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 31));
	        lblNewLabel.setBounds(10, 11, 674, 86);
	        contentPane.add(lblNewLabel);
	        frame.setSize(700,500);
	        frame.setLocationByPlatform(false);
	        frame.setVisible(true);
		
	}

	public static void main(String... args)
    {
              new CustomerAccountwiseFrame();
    }
}