package com.logistics.turvo.eventlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.logistics.turvo.events.CustomEventCreated;
import com.logistics.turvo.notification.service.ShipmentCreatedService;
import com.logistics.turvo.repository.message.queue.CustomMessageQueue;

@Component
public class CreatedEventHandler implements ApplicationListener<CustomEventCreated> {

	@Autowired
	private CustomMessageQueue customMessageQueue;
	
	@Autowired
	private ShipmentCreatedService shipmentCreatedService;
	
	@Override
	public void onApplicationEvent(CustomEventCreated event) {
		shipmentCreatedService.sendNotification(customMessageQueue.getShipmentCreateQueue().poll());
	}


}
