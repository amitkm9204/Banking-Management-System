package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;


public class ParticularCustomerInformationFrame extends JFrame
{
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAccNo;
	private JTextField txtBal;
	
	
	public ParticularCustomerInformationFrame()
	{
		formopen();
	}
	
	
	private void formopen()
	{
		setResizable(false);
		setTitle("PERSONAL CUSTOMER INFORMATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginPage.class.getResource("/resources/clerk-with-tie.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("NAME : ");
		lbl1.setForeground(new Color(0, 0, 0));
		lbl1.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		lbl1.setBounds(157, 144, 82, 20);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("ACCOUNT NO : ");
		lbl2.setForeground(new Color(0, 0, 0));
		lbl2.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		lbl2.setBounds(73, 243, 166, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("BALANCE : ");
		lbl3.setForeground(new Color(0, 0, 0));
		lbl3.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		lbl3.setBounds(119, 330, 120, 19);
		contentPane.add(lbl3);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(295, 140, 247, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAccNo = new JTextField();
		txtAccNo.setEditable(false);
		txtAccNo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtAccNo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAccNo.setBounds(295, 236, 247, 32);
		contentPane.add(txtAccNo);
		txtAccNo.setColumns(10);
		
		txtBal = new JTextField();
		txtBal.setEditable(false);
		txtBal.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtBal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtBal.setBounds(295, 325, 247, 32);
		contentPane.add(txtBal);
		txtBal.setColumns(10);
		
		JLabel lblPersonalAccountInformation = new JLabel("PERSONAL CUSTOMER INFORMATION");
		lblPersonalAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPersonalAccountInformation.setForeground(Color.BLUE);
		lblPersonalAccountInformation.setBounds(89, 25, 470, 58);
		contentPane.add(lblPersonalAccountInformation);
		
		
		setVisible(true);
	}
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParticularCustomerInformationFrame frame = new ParticularCustomerInformationFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
