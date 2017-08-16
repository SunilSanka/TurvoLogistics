package com.logistics.turvo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.model.Users;
import com.logistics.turvo.notification.service.CreatedEvent;
import com.logistics.turvo.notification.service.DeliveredEvent;
import com.logistics.turvo.notification.service.PackedEvent;
import com.logistics.turvo.notification.service.RunningLateEvent;
import com.logistics.turvo.notification.service.ShippedEvent;

@Service
public class NotificationHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationHelper.class);
	
@Autowired
private CreatedEvent createEvent;
@Autowired
private PackedEvent packedEvent;
@Autowired
private ShippedEvent shippedEvent;
@Autowired
private RunningLateEvent runningLateEvent;
@Autowired
private DeliveredEvent deliveredEvent;
	
	/**
	 * This method is used to Notify the Subscribed users about the occurrence of the events.
	 * @param shipment
	 */
	public void notify(Shipment shipment){
		String status = shipment.getStatus();
		StringBuffer message = new StringBuffer();
		message.append("Shipment Id:"+String.valueOf(shipment.getShipmentId())+" has been "+status+":"+shipment.getMessage());
		
		switch(status){
		
		case "Created":
				createEvent.sendNotification(message.toString());
		break;
		
		case "Packed":
			 packedEvent.sendNotification(message.toString());
		break;
		
		case "Shipped":
			shippedEvent.sendNotification(message.toString());
		break;
		
		case "RunningLate":
			runningLateEvent.sendNotification(message.toString());
		break;
			
		case "Delivered":
			deliveredEvent.sendNotification(message.toString());
		break;
		
		}
	}
	/**
	 * This method is used to subscribe the users to different shipment events
	 * @param user
	 */
	public void subscribe(Users user){
		if(user.isShipment_Created()){
			createEvent.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Creation Event");
		}
		if(user.isShipment_Delivered()){
			deliveredEvent.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Delivery Event");
		}
		if(user.isShipment_Packed()){
			packedEvent.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Packed Event");
		}
		if(user.isShipment_Running_Late()){
			runningLateEvent.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Running Late Event");
		}
		if(user.isShipment_Shipped()){
			shippedEvent.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Shipped Event");
		}
	}

}
