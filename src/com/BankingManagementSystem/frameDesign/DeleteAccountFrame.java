package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.CustomerDetails;

public class DeleteAccountFrame extends JFrame
{
	JTextField tdel;
    public DeleteAccountFrame()
    {
        JFrame frmDeleteAccount = new JFrame("Delete an account...");
        frmDeleteAccount.setTitle("DELETE ACCOUNT");
        frmDeleteAccount.setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/delete.png")));
        
        //frmDeleteAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDeleteAccount.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        frmDeleteAccount.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	frmDeleteAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	frmDeleteAccount.setVisible(false);
            	frmDeleteAccount.dispose();
                    
                }
        }
        );
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setLayout(null);
        
        
        JLabel label = new JLabel("ACCOUNT NO : ", JLabel.CENTER);
        Font f1=new Font("comic sans ms",Font.BOLD,26);
        label.setFont(f1);
        label.setForeground(Color.RED);
        label.setSize(237,50);
        label.setLocation(44,207);
        contentPane.add(label);
        
        
         tdel = new JTextField();
        tdel.setToolTipText("ENTER ACCOUNT NUMBER");
        tdel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Font f3=new Font("comic sans ms",Font.ITALIC,18);
        tdel.setFont(new Font("Consolas", Font.BOLD, 28));
        tdel.setSize(342,50);
        tdel.setLocation(305,211);
        contentPane.add(tdel);
        
        
        
        JButton bmanager = new JButton("DELETE ACCOUNT");
        bmanager.setToolTipText("DELETE ACCOUNT");
        bmanager.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bmanager.setFont(f2);
        bmanager.setForeground(new Color(255, 20, 147));
        bmanager.setSize(245,71);
        bmanager.setLocation(402,323);
        bmanager.setFocusable(true);
        contentPane.add(bmanager);
        
        bmanager.addActionListener((e)->
        {
        	
        	deleteAccount();
        });

        frmDeleteAccount.setContentPane(contentPane);
        
        JLabel lblDeleteParticularCustomer = new JLabel("DELETE PARTICULAR CUSTOMER");
        lblDeleteParticularCustomer.setForeground(new Color(148, 0, 211));
        lblDeleteParticularCustomer.setFont(new Font("Times New Roman", Font.BOLD, 38));
        lblDeleteParticularCustomer.setBounds(18,20, 664, 105);
        contentPane.add(lblDeleteParticularCustomer);
        frmDeleteAccount.setSize(700,500);
        frmDeleteAccount.setLocationByPlatform(false);
        frmDeleteAccount.setVisible(true);
        frmDeleteAccount.setResizable(false);
    }

    public void deleteAccount()
    {
    	
    	try{
    			int idfoundpos = Search.searchId(tdel.getText().trim());

    			if(idfoundpos >= 0)
    			{
    				int result = JOptionPane.showConfirmDialog(
    						null, "Are you sure?");
    				if( result==JOptionPane.OK_OPTION)
    				{
    				ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
    				userlist.remove(idfoundpos);
    				CustomerDetailsFile.writeDatatoFile(userlist);
    				JOptionPane.showMessageDialog(this, "Account deletion successfull");
    				}
    			}
    			else
    				{
    					JOptionPane.showMessageDialog(this, "Invalid Account number");
    				}
    	}catch (Exception e) {
			JOptionPane.showInternalConfirmDialog(this,"Invalid Input");
		}
    	
    }
   /* public static void main(String... args)
    {
              new DeleteAccountFrame();
    }*/
}