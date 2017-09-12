package com.logistics.turvo.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.logistics.turvo.eventpublisher.service.EventPublisher;
import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.model.Users;
import com.logistics.turvo.notification.service.ShipmentCreatedService;
import com.logistics.turvo.notification.service.ShipmentDeliveredService;
import com.logistics.turvo.notification.service.ShipmentPackedService;
import com.logistics.turvo.notification.service.ShipmentRunningLateService;
import com.logistics.turvo.notification.service.ShipmentShippedService;
import com.logistics.turvo.repository.UserReposiroty;
import com.logistics.turvo.repository.message.queue.CustomMessageQueue;

@Service
public class NotificationHelper implements ApplicationListener<ContextRefreshedEvent>{
	
private static final Logger logger = LoggerFactory.getLogger(NotificationHelper.class);
	
private ApplicationContext context;

@Autowired
private UserReposiroty userRepo;
	
@Autowired
private ShipmentCreatedService shipmentCreatedService;
@Autowired
private ShipmentPackedService shipmentPackedService;
@Autowired
private ShipmentShippedService shipmentShippedService;
@Autowired
private ShipmentRunningLateService shipmentRunningLateService;
@Autowired
private ShipmentDeliveredService shipmentDeliveredService;

//Event Publisher
private EventPublisher eventPublisher;

@Autowired
private CustomMessageQueue customMessageQuery;

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
				//createEvent.sendNotification(message.toString());
			customMessageQuery.getShipmentCreateQueue().offer(message.toString());
			eventPublisher =   context.getBean(EventPublisher.class);
			eventPublisher.publishCreate();
		break;
		
		case "Packed":
			 //packedEvent.sendNotification(message.toString());
			customMessageQuery.getShipmentPackedQueue().offer(message.toString());
			//eventPublisher.publishPacked();
		break;
		
		case "Shipped":
			//shippedEvent.sendNotification(message.toString());
			customMessageQuery.getShipmentPackedQueue().offer(message.toString());
			//eventPublisher.publishShipped();
		break;
		
		case "RunningLate":
			//runningLateEvent.sendNotification(message.toString());
			customMessageQuery.getShipmentRunningLateQueue().offer(message.toString());
			//eventPublisher.publishRunningLate();
		break;
			
		case "Delivered":
			//deliveredEvent.sendNotification(message.toString());
			customMessageQuery.getShipmentDeliveredQueue().offer(message.toString());
			//eventPublisher.publishDelivered();
		break;
		
		}
	}
	/**
	 * This method is used to subscribe the users to different shipment events
	 * @param user
	 */
	public void subscribe(Users user){
		if(user.isShipment_Created()){
			shipmentCreatedService.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Creation Event");
		}
		if(user.isShipment_Delivered()){
			shipmentDeliveredService.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Delivery Event");
		}
		if(user.isShipment_Packed()){
			shipmentPackedService.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Packed Event");
		}
		if(user.isShipment_Running_Late()){
			shipmentRunningLateService.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Running Late Event");
		}
		if(user.isShipment_Shipped()){
			shipmentShippedService.subUsers.add(user.getUserId());
			logger.info("User "+user.getUserId()+" has been subscribed to Shipment Shipped Event");
		}
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		context = event.getApplicationContext();
		
		//User Subscription
		List<Users> users = userRepo.findAll();
		
		for(Users user : users){
			this.subscribe(user);
		}
	}

}
