package com.logistics.turvo.notification.service;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.logistics.turvo.channel.service.IChannelService;
import com.logistics.turvo.model.Users;
import com.logistics.turvo.repository.UserReposiroty;
import com.logistics.turvo.ws.Producer;

@Component
public class NotifyAction implements Consumer<Object> {
	private static final Logger logger = LoggerFactory.getLogger(NotifyAction.class);
	
private Users user;
private String message;
@Autowired
private UserReposiroty userRepo;

@Autowired
@Qualifier("emailService")
private IChannelService emailService;

@Autowired
@Qualifier("smsService")
private IChannelService smsService;

@Autowired
@Qualifier("callService")
private IChannelService callService;

@Autowired
private Producer wsProducer;

	@Override
	public void accept(Object obj) {
		user = userRepo.findOne((Long)obj);
		logger.info("Action for user:"+user.getUserId()+" on web:"+user.isBy_Web()+",email"+user.isBy_Email()+" and sms"+user.isBy_SMS());
		
		if (user.isBy_Web()) {
			logger.info("Send notification via Web for user :"+user.getUserId() );
			wsProducer.send(String.valueOf(user.getUserId()), this.getMessage());
		}  if (user.isBy_Email()) {
			logger.info("Send notification via Email for user :"+user.getUserId());
			emailService.notify(user.getEmail(),this.getMessage());
		}  if (user.isBy_SMS()) {
			logger.info("Send notification via SMS for user :"+user.getUserId());
			smsService.notify(user.getNumber(), this.getMessage());
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
