package com.logistics.turvo.eventlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.logistics.turvo.events.CustomEventDelivered;
import com.logistics.turvo.notification.service.ShipmentDeliveredService;
import com.logistics.turvo.repository.message.queue.CustomMessageQueue;

@Component
public class DeliveredEventHadler implements ApplicationListener<CustomEventDelivered> {

	@Autowired
	private CustomMessageQueue customMessageQueue;
	
	@Autowired
	private ShipmentDeliveredService shipmentDeliveredService;
	
	@Override
	public void onApplicationEvent(CustomEventDelivered event) {
		shipmentDeliveredService.sendNotification(customMessageQueue.getShipmentDeliveredQueue().poll());
	}

}
