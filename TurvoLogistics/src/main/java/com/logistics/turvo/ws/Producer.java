package com.logistics.turvo.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	@Autowired
	private SimpMessagingTemplate brokerMessagingTemplate;

	
	public void send(String destination, String message){
		logger.info("Sending message = '{}' to destination = '{}'", message,destination);
		this.brokerMessagingTemplate.convertAndSend("/topic/"+destination,message);
		logger.info("send sim  message sent '{}'",message);
	}
}
