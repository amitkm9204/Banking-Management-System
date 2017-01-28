package com.BankingManagementSystem.frameDesign;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.BankingManagementSystem.Pojo.ManagerDetails;

public class Managerframe extends JFrame
{
	
      public Managerframe()  {
        JFrame frame = new JFrame("Manager");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(76, 224, 230));
        contentPane.setLayout(null);
        ManagerDetails managerDetails = new ManagerDetails();
        //JLabel label = new JLabel(managerDetails.getManagerName(), JLabel.CENTER);
        JLabel label = new JLabel("Manager Name", JLabel.CENTER);
        Font f1=new Font("comic sans ms",Font.BOLD,48);
        label.setFont(f1);
        label.setForeground(Color.RED);
        label.setSize(400,200);
        label.setLocation(50,5);
        contentPane.add(label);
        
        
        JButton bpassBook = new JButton("PassBook/CheckBook");
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bpassBook.setFont(f2);
        bpassBook.setForeground(Color.BLUE);
        bpassBook.setSize(200,80);
        bpassBook.setLocation(150,150);
        bpassBook.setFocusable(false);
        contentPane.add(bpassBook);
        
        
       JButton btransSummary = new JButton("Transaction summary");
       btransSummary.setFont(f2);
       btransSummary.setForeground(Color.BLUE);
       btransSummary.setSize(200,80);
       btransSummary.setLocation(150,250);
       btransSummary.setFocusable(false);
       contentPane.add(btransSummary);
       
 
       JButton bCustomerInfo = new JButton("Customer Info");
       bCustomerInfo.setFont(f2);
       bCustomerInfo.setForeground(Color.BLUE);
       bCustomerInfo.setSize(200,80);
       bCustomerInfo.setLocation(150,350);
       bCustomerInfo.setFocusable(false);
       contentPane.add(bCustomerInfo);
       
       JButton bAccountantInfo = new JButton("Accountant Info");
       bAccountantInfo.setFont(f2);
       bAccountantInfo.setForeground(Color.BLUE);
       bAccountantInfo.setSize(200,80);
       bAccountantInfo.setLocation(150,450);
       bAccountantInfo.setFocusable(false);
       contentPane.add(bAccountantInfo);

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