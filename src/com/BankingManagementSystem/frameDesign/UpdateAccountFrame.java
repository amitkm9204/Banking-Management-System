package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateAccountFrame
{
    public UpdateAccountFrame()
    {
        JFrame frame = new JFrame("Update an account...");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        
        
        JLabel label = new JLabel("ACCOUNT NO : ", JLabel.CENTER);
        Font f1=new Font("comic sans ms",Font.BOLD,22);
        label.setFont(f1);
        label.setForeground(Color.RED);
        label.setSize(300,200);
        label.setLocation(5,5);
        contentPane.add(label);
        
        JLabel label1 = new JLabel("NAME : ", JLabel.CENTER);
        label1.setFont(f1);
        label1.setForeground(Color.RED);
        label1.setSize(300,200);
        label1.setLocation(50,70);
        contentPane.add(label1);
        
        
        JLabel label2 = new JLabel("ADDRESS : ", JLabel.CENTER);
        label2.setFont(f1);
        label2.setForeground(Color.RED);
        label2.setSize(300,200);
        label2.setLocation(30,135);
        contentPane.add(label2);
        
        
        JLabel label3 = new JLabel("PHONE NO : ", JLabel.CENTER);
        label3.setFont(f1);
        label3.setForeground(Color.RED);
        label3.setSize(300,200);
        label3.setLocation(20,195);
        contentPane.add(label3);
        
        
        JTextField taccno = new JTextField(20);
        Font f3=new Font("consolas",Font.ITALIC,20);
        taccno.setFont(f3);
        taccno.setSize(300,40);
        taccno.setLocation(300,88);
        contentPane.add(taccno);
        
        JTextField tname = new JTextField(20);
        tname.setFont(f3);
        tname.setSize(300,40);
        tname.setLocation(300,153);
        contentPane.add(tname);
        
        JTextArea tadd=new JTextArea(5,20);
		JScrollPane taddsp=new JScrollPane(tadd);
		Font f4=new Font("consolas",Font.ITALIC,20);
        taddsp.setFont(f4);
        taddsp.setSize(300,40);
        taddsp.setLocation(300,218);
        contentPane.add(taddsp);
        
        JTextField tphn = new JTextField(20);
        tphn.setFont(f3);
        tphn.setSize(300,40);
        tphn.setLocation(300,282);
        contentPane.add(tphn);
        
        
        
        JButton bdel = new JButton("UPDATE");
        Font f2=new Font("comic sans ms",Font.BOLD,22);
        bdel.setFont(f2);
        bdel.setForeground(Color.BLUE);
        bdel.setSize(200,80);
        bdel.setLocation(340,380);
        bdel.setFocusable(true);
        contentPane.add(bdel);
        

        frame.setContentPane(contentPane);
        frame.setSize(800,600);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
              new UpdateAccountFrame();
    }
}