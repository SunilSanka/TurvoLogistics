package com.logistics.turvo.channel.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailService")
public class EmailService implements IChannelService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	private JavaMailSender mailSender;
	
	@Autowired
	public EmailService(JavaMailSender mailSender) {
	this.mailSender = mailSender;
	}
	
	public void notify(String recepient,String message){
		
		 try{
			 //Prepare Mime Message
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("turvo.logistics@gmail.com");
			messageHelper.setTo(recepient);
			messageHelper.setSubject("Shipment Update");
			messageHelper.setText(message);
			
			//Send the Mime message
			 mailSender.send(mimeMessage);
			 logger.info("Email Send Successfully !");
		 }catch(MailException e){
			 logger.info("Unable to send email :"+e.getMessage());
			 //e.printStackTrace();
		} catch (MessagingException me) {
			 logger.info("Unable to send email notification :"+me.getMessage());
			 //me.printStackTrace();
		}
	}
}
