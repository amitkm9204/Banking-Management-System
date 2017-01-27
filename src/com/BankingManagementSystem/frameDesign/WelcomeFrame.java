package com.BankingManagementSystem.frameDesign;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeFrame
{
     public WelcomeFrame() {
        JFrame frame = new JFrame("Welcome...");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        JLabel label = new JLabel("Welcome To Banking Management System", JLabel.CENTER);
        Font f1=new Font("comic sans ms",Font.BOLD,48);
        label.setFont(f1);
        label.setForeground(Color.RED);
        label.setSize(1300,150);
        label.setLocation(50,5);
        contentPane.add(label);
        
        
        JButton bmanager = new JButton("MANAGER");
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bmanager.setFont(f2);
        bmanager.setForeground(Color.BLUE);
        bmanager.setSize(200,80);
        bmanager.setLocation(400,500);
        bmanager.setFocusable(false);
        contentPane.add(bmanager);
        
        
       JButton baccountant = new JButton("ACCOUNTANT");
       baccountant.setFont(f2);
       baccountant.setForeground(Color.BLUE);
        baccountant.setSize(200,80);
        baccountant.setLocation(800,500);
        baccountant.setFocusable(false);
        contentPane.add(baccountant);
 

        frame.setContentPane(contentPane);
        frame.setSize(1378,780);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
    }

    /*public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new WelcomeFrame().displayGUI();
            }
        });
    }*/
}