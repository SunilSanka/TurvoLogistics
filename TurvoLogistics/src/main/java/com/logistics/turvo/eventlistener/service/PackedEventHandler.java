package com.logistics.turvo.eventlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.logistics.turvo.events.CustomEventPacked;
import com.logistics.turvo.notification.service.ShipmentPackedService;
import com.logistics.turvo.repository.message.queue.CustomMessageQueue;

@Component
public class PackedEventHandler implements ApplicationListener<CustomEventPacked>{

	@Autowired
	private CustomMessageQueue customMessageQueue;
	
	@Autowired
	private ShipmentPackedService shipmentPackedService;
	
	@Override
	public void onApplicationEvent(CustomEventPacked event) {
		shipmentPackedService.sendNotification(customMessageQueue.getShipmentPackedQueue().poll());
	}

}
