package com.BankingManagementSystem.frameDesign;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import com.BankingManagementSystem.Pojo.ManagerDetails;

public class Managerframe extends JFrame
{
	
      public Managerframe()  {
        JFrame frame = new JFrame("Manager");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(245, 222, 179));
        contentPane.setLayout(null);
        ManagerDetails managerDetails = new ManagerDetails();
        JLabel label = new JLabel("Manager Name", JLabel.CENTER);
        label.setToolTipText("Manager's Name");
        Font f1=new Font("comic sans ms",Font.BOLD,48);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        label.setForeground(new Color(0, 128, 0));
        label.setSize(269,43);
        label.setLocation(255,110);
        contentPane.add(label);
        
        
        JButton bpassBook = new JButton("Passbook Or Cheque Book");
        bpassBook.setToolTipText("Passbook and Cheque book issuing");
        bpassBook.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bpassBook.setFont(f2);
        bpassBook.setForeground(new Color(160, 82, 45));
        bpassBook.setSize(300,80);
        bpassBook.setLocation(100,189);
        bpassBook.setFocusable(false);
        contentPane.add(bpassBook);
        
        
        JButton btransSummary = new JButton("Transaction summary");
        btransSummary.setToolTipText("All Transation Summary");
        btransSummary.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btransSummary.setFont(f2);
        btransSummary.setForeground(new Color(160, 82, 45));
        btransSummary.setSize(300,80);
        btransSummary.setLocation(100,291);
        btransSummary.setFocusable(false);
        contentPane.add(btransSummary);
       
 
        JButton bCustomerInfo = new JButton("Customer Information");
        bCustomerInfo.setToolTipText("Customer's details");
        bCustomerInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        bCustomerInfo.setFont(f2);
        bCustomerInfo.setForeground(new Color(160, 82, 45));
        bCustomerInfo.setSize(300,80);
        bCustomerInfo.setLocation(100,394);
        bCustomerInfo.setFocusable(false);
        contentPane.add(bCustomerInfo);
       
        JButton bAccountantInfo = new JButton("Accountant Information");
        bAccountantInfo.setToolTipText("Accountant's Details");
        bAccountantInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        bAccountantInfo.setFont(f2);
        bAccountantInfo.setForeground(new Color(160, 82, 45));
        bAccountantInfo.setSize(300,80);
        bAccountantInfo.setLocation(100,494);
        bAccountantInfo.setFocusable(false);
        contentPane.add(bAccountantInfo);

        JLabel lblManagerName = new JLabel("Manager Name :", SwingConstants.CENTER);
        lblManagerName.setForeground(Color.RED);
        lblManagerName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblManagerName.setBounds(10, 110, 246, 43);
        contentPane.add(lblManagerName);
        
        JLabel lblNewLabel = new JLabel("MANAGER PANEL");
        lblNewLabel.setForeground(new Color(106, 90, 205));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblNewLabel.setBounds(104, 0, 364, 67);
        contentPane.add(lblNewLabel);
        
        frame.setContentPane(contentPane);
        frame.setSize(500,600);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
    }

      public static void main(String... args)
      {
          SwingUtilities.invokeLater(new Runnable()
          {
              public void run()
              {
                  new Managerframe();
              }
          });
      }
}