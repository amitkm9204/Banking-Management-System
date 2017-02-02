package com.BankingManagementSystem.ValidationChecking;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSender {
	public static boolean sendMail(String from ,String password,String message,String[] to)
	{
		String host="smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		
		Session session=Session.getDefaultInstance(props,null);
		MimeMessage mimemessage=new MimeMessage(session);
		try{
			mimemessage.setFrom(new InternetAddress(from));
			InternetAddress[] toAddresses=new InternetAddress[to.length];
			for(int i=0;i<to.length;i++){
				toAddresses[i]=new InternetAddress(to[i]);
			}
			for(int i=0;i<toAddresses.length;i++){
				mimemessage.addRecipient(RecipientType.TO, toAddresses[i]);
					
			}
			//add subject
			mimemessage.setSubject("Email from Banking Management System");
			//set message to mimemessage
			mimemessage.setText(message);
			Transport transport=session.getTransport("smtp");
			transport.connect(host,from,password);
			transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
			transport.close();
			return true;
			
			
		}catch (MessagingException me) {
					me.printStackTrace();
		}
		
		return false;
	}

}
