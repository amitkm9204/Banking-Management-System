package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;


public class ParticularAccountantInformationFrame extends JFrame
{
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSalary;
	private JTextField txtJoiningDate;
	
	
	public ParticularAccountantInformationFrame()
	{
		formopen();
	}
	
	
	private void formopen()
	{
		setResizable(false);
		setTitle("PERSONAL ACCOUNTANT INFORMATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginPage.class.getResource("/resources/accounting-book.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
               // if( result==JOptionPane.OK_OPTION){
                    // NOW we change it to dispose on close..
                    setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    setVisible(false);
                    dispose();
                    new AccountantFrame();
                }
            
        });
        */
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
		
		JLabel lbl2 = new JLabel("SALARY : ");
		lbl2.setForeground(new Color(0, 0, 0));
		lbl2.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		lbl2.setBounds(138, 243, 101, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("JOINING DATE : ");
		lbl3.setForeground(new Color(0, 0, 0));
		lbl3.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		lbl3.setBounds(64, 330, 181, 19);
		contentPane.add(lbl3);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(295, 140, 247, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setEditable(false);
		txtSalary.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtSalary.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSalary.setBounds(295, 236, 247, 32);
		contentPane.add(txtSalary);
		txtSalary.setColumns(10);
		
		txtJoiningDate = new JTextField();
		txtJoiningDate.setEditable(false);
		txtJoiningDate.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtJoiningDate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtJoiningDate.setBounds(295, 325, 247, 32);
		contentPane.add(txtJoiningDate);
		txtJoiningDate.setColumns(10);
		
		JLabel lblPersonalAccountInformation = new JLabel("PERSONAL ACCOUNTANT INFORMATION");
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
					ParticularAccountantInformationFrame frame = new ParticularAccountantInformationFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
