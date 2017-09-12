package com.logistics.turvo.eventlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.logistics.turvo.events.CustomEventShipped;
import com.logistics.turvo.notification.service.ShipmentShippedService;
import com.logistics.turvo.repository.message.queue.CustomMessageQueue;

@Component
public class ShippedEventHandler implements ApplicationListener<CustomEventShipped> {

	@Autowired
	private CustomMessageQueue customMessageQueue;
	
	@Autowired
	private ShipmentShippedService shipementShippedService;
	
	@Override
	public void onApplicationEvent(CustomEventShipped event) {
		shipementShippedService.sendNotification(customMessageQueue.getShipmentShippedQueue().poll());
	}
}
