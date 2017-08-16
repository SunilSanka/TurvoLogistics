package com.logistics.turvo.mail;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SendEmailTest {

	String to ="sunil.grt@gmail.com";
	String from ="turvo.logistics@gmail.com";
	String password = "TurvoAdmin@123";
	String host = "smtp.gmail.com";
	
	Authenticator auth = new Authenticator() {
		//override the getPasswordAuthentication method
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(from, password);
		}
	};
	
	Properties props = System.getProperties();
	
	@Test
	public void smtpProperties(){
		props.setProperty("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
			
		assertNotNull(props);
	}
	
	@Test
	public void sendMIME(){
		try{
			//Get the session
			Session session = Session.getDefaultInstance(props, auth);
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject("Ping");
			message.setText("Hello, This is an example email!");
			
			assertNotNull(session);
			assertNotNull(message);
			
			//Send Message
			Transport.send(message);
			
			System.out.println("message sent successfully !");
		}
		 catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
