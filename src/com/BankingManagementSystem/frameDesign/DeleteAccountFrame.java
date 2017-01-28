package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;

public class DeleteAccountFrame extends JFrame
{
	JTextField tdel;
    public DeleteAccountFrame()
    {
        JFrame frame = new JFrame("Delete an account...");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(76, 224, 230));
        contentPane.setLayout(null);
        
        
        JLabel label = new JLabel("ACCOUNT NO : ", JLabel.CENTER);
        Font f1=new Font("comic sans ms",Font.BOLD,26);
        label.setFont(f1);
        label.setForeground(Color.RED);
        label.setSize(300,200);
        label.setLocation(5,5);
        contentPane.add(label);
        
        
         tdel = new JTextField();
        Font f3=new Font("comic sans ms",Font.ITALIC,18);
        tdel.setFont(f3);
        tdel.setSize(300,50);
        tdel.setLocation(300,85);
        contentPane.add(tdel);
        
        
        
        JButton bmanager = new JButton("DELETE");
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bmanager.setFont(f2);
        bmanager.setForeground(Color.BLUE);
        bmanager.setSize(200,80);
        bmanager.setLocation(340,250);
        bmanager.setFocusable(true);
        contentPane.add(bmanager);
        
        bmanager.addActionListener((e)->
        {
        	deleteAccount();
        });

        frame.setContentPane(contentPane);
        frame.setSize(750,450);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
    }

    public void deleteAccount()
    {
    	 int idfoundpos = Search.searchId(tdel.getText().trim());

         if(idfoundpos >= 0)
         {
        	 ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
        	 userlist.remove(idfoundpos);
        	 CustomerDetailsFile.writeDatatoFile(userlist);
        	 JOptionPane.showMessageDialog(this, "Account deletion successfull");
         }
         else
         {
            JOptionPane.showMessageDialog(this, "Invalid Account number");
         }
    	
    }
    public static void main(String... args)
    {
              new DeleteAccountFrame();
    }
}