package com.logistics.turvo.eventlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.logistics.turvo.events.CustomEventRunningLate;
import com.logistics.turvo.notification.service.ShipmentRunningLateService;
import com.logistics.turvo.repository.message.queue.CustomMessageQueue;

@Component
public class RunningLateEventHandler implements ApplicationListener<CustomEventRunningLate> {
	
	@Autowired
	private CustomMessageQueue customMessageQueue;
	
	@Autowired
	private ShipmentRunningLateService shipmentRunningLateService;
	
	@Override
	public void onApplicationEvent(CustomEventRunningLate event) {
		shipmentRunningLateService.sendNotification(customMessageQueue.getShipmentRunningLateQueue().poll());
	}
}
