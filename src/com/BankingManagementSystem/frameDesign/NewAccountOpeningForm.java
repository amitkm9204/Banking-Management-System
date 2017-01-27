package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;


class AccountOpening extends JFrame
{
	private JPanel AccountOpening;
	private JLabel lblName,lblSex,lblDOB,lblFathersName,lblMothersName,lblPhone,lblAddress,lblVoterId,lblAadhaar,
					lblPANId,lblEmailId;
	private JTextField txtName,txtFathersName,txtMothersName,txtPhone,txtVoterId,txtAadhaar,txtPANId,txtEmailId;
	private JButton btnOpen;
	private JTextArea txtAddress;
	private final ButtonGroup sex = new ButtonGroup();
	private JComboBox cbDay,cbMonth,cbYear;
	private String Day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String Month[] = {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Nov","Dec"};
	private String Year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011"};
	
	public AccountOpening()
	{
		formOpen();
	}
	

	private void formOpen() 
	{
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(NewAccountOpeningForm.class.getResource("/resources/Forms.png")));
		setTitle("New Account Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 780);
		AccountOpening = new JPanel();
		AccountOpening.setBackground(new Color(76, 224, 230));
		AccountOpening.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AccountOpening);
		AccountOpening.setLayout(null);
		
		
		JLabel lblForm = new JLabel("Account Opening Form");
		lblForm.setForeground(new Color(119, 12, 47));
		lblForm.setFont(new Font("Trajan Pro 3", Font.BOLD, 48));
		lblForm.setBounds(350, 21, 854, 52);
		AccountOpening.add(lblForm);
		
		
		lblName = new JLabel("NAME :");
		lblName.setForeground(new Color(0,0,0));
		lblName.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblName.setBounds(220, 100, 94, 51);
		AccountOpening.add(lblName);
		
		
		lblDOB = new JLabel("DATE OF BIRTH :");
		lblDOB.setForeground(new Color(0,0,0));
		lblDOB.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblDOB.setBounds(120, 150, 200, 51);
		AccountOpening.add(lblDOB);
		
		
		lblSex = new JLabel("SEX :");
		lblSex.setForeground(new Color(0,0,0));
		lblSex.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblSex.setBounds(240, 200, 200, 51);
		AccountOpening.add(lblSex);
		
		
		lblFathersName = new JLabel("FATHER'S NAME :");
		lblFathersName.setForeground(new Color(0,0,0));
		lblFathersName.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblFathersName.setBounds(105, 250, 200, 51);
		AccountOpening.add(lblFathersName);
		
		
		lblMothersName = new JLabel("MOTHER'S NAME :");
		lblMothersName.setForeground(new Color(0,0,0));
		lblMothersName.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblMothersName.setBounds(98, 300, 200, 51);
		AccountOpening.add(lblMothersName);
		
		
		lblAddress = new JLabel("ADDRESS :");
		lblAddress.setForeground(new Color(0,0,0));
		lblAddress.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblAddress.setBounds(173, 350, 200, 51);
		AccountOpening.add(lblAddress);
		
		
		lblPhone = new JLabel("PHONE :");
		lblPhone.setForeground(new Color(0,0,0));
		lblPhone.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblPhone.setBounds(208, 450, 200, 51);
		AccountOpening.add(lblPhone);
		
		
		lblVoterId = new JLabel("VOTER ID :");
		lblVoterId.setForeground(new Color(0,0,0));
		lblVoterId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblVoterId.setBounds(183, 500, 200, 51);
		AccountOpening.add(lblVoterId);
		
		
		lblAadhaar = new JLabel("AADHAAR NO. :");
		lblAadhaar.setForeground(new Color(0,0,0));
		lblAadhaar.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblAadhaar.setBounds(127, 550, 200, 51);
		AccountOpening.add(lblAadhaar);
		
		
		lblPANId = new JLabel("PAN :");
		lblPANId.setForeground(new Color(0,0,0));
		lblPANId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblPANId.setBounds(236, 600, 200, 51);
		AccountOpening.add(lblPANId);
		
		
		lblEmailId = new JLabel("EMAIL :");
		lblEmailId.setForeground(new Color(0,0,0));
		lblEmailId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblEmailId.setBounds(212, 650, 200, 51);
		AccountOpening.add(lblEmailId);
		
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(330, 105, 500, 40);
		AccountOpening.add(txtName);
		txtName.setColumns(10);
		
		
		cbDay = new JComboBox(Day);
		cbDay.setToolTipText("");
		cbDay.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbDay.setBackground(new Color(255, 255, 255));
		cbDay.setBounds(330, 160, 80, 30);
		AccountOpening.add(cbDay);
		
		
		cbDay = new JComboBox();
		cbDay.setToolTipText("");
		cbDay.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbDay.setBackground(new Color(255, 255, 255));
		cbDay.setBounds(330, 160, 100, 30);
		AccountOpening.add(cbDay);
		
		cbMonth = new JComboBox(Month);
		cbMonth.setToolTipText("");
		cbMonth.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbMonth.setBackground(new Color(255, 255, 255));
		cbMonth.setBounds(450, 160, 120, 30);
		AccountOpening.add(cbMonth);
		
		cbYear = new JComboBox(Year);
		cbYear.setToolTipText("");
		cbYear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbYear.setBackground(new Color(255, 255, 255));
		cbYear.setBounds(600, 160, 120, 30);
		AccountOpening.add(cbYear);
		
		
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(76, 224, 230));
		rdbtnMale.setFont(new Font("Times New Roman", Font.BOLD, 22));
		sex.add(rdbtnMale);
		rdbtnMale.setBounds(330, 210, 109, 23);
		AccountOpening.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(76, 224, 230));
		rdbtnFemale.setFont(new Font("Times New Roman", Font.BOLD, 22));
		sex.add(rdbtnFemale);
		rdbtnFemale.setBounds(450, 210, 109, 23);
		AccountOpening.add(rdbtnFemale);
		
		
		txtFathersName = new JTextField();
		txtFathersName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtFathersName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFathersName.setBounds(330, 253, 500, 40);
		AccountOpening.add(txtFathersName);
		txtFathersName.setColumns(10);
		
		
		txtMothersName = new JTextField();
		txtMothersName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtMothersName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtMothersName.setBounds(330, 303, 500, 40);
		AccountOpening.add(txtMothersName);
		txtMothersName.setColumns(10);
		
		
		txtAddress = new JTextArea();
		txtAddress.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddress.setBounds(330, 353, 500, 70);
		AccountOpening.add(txtAddress);
		
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPhone.setBounds(330, 453, 500, 40);
		AccountOpening.add(txtPhone);
		txtPhone.setColumns(10);
		
		
		txtVoterId = new JTextField();
		txtVoterId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtVoterId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtVoterId.setBounds(330, 503, 500, 40);
		AccountOpening.add(txtVoterId);
		txtVoterId.setColumns(10);
		
		
		txtAadhaar = new JTextField();
		txtAadhaar.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAadhaar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAadhaar.setBounds(330, 553, 500, 40);
		AccountOpening.add(txtAadhaar);
		txtAadhaar.setColumns(10);
		
		
		txtPANId = new JTextField();
		txtPANId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtPANId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPANId.setBounds(330, 603, 500, 40);
		AccountOpening.add(txtPANId);
		txtPANId.setColumns(10);
		
		
		txtEmailId = new JTextField();
		txtEmailId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtEmailId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmailId.setBounds(330, 653, 500, 40);
		AccountOpening.add(txtEmailId);
		txtEmailId.setColumns(10);
		
		btnOpen = new JButton("OPEN");
		btnOpen.setBorderPainted(false);
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnOpen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnOpen.setForeground(new Color(155, 140, 0));
		btnOpen.setBackground(new Color(246, 224, 130));
		btnOpen.setBounds(680, 703, 150, 35);
		AccountOpening.add(btnOpen);
		
	}
	
	
}


public class NewAccountOpeningForm 
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AccountOpening form = new AccountOpening();
					form.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});


	}

}
