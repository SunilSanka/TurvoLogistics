package com.logistics.turvo.eventpublisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.logistics.turvo.events.CustomEventCreated;
import com.logistics.turvo.events.CustomEventDelivered;
import com.logistics.turvo.events.CustomEventPacked;
import com.logistics.turvo.events.CustomEventRunningLate;
import com.logistics.turvo.events.CustomEventShipped;

@Component
public class EventPublisher implements ApplicationEventPublisherAware {

 private static final Logger logger = LoggerFactory.getLogger(EventPublisher.class);
	
	private CustomEventCreated createEvent;
	private CustomEventDelivered deliveredEvent;
	private CustomEventPacked packedEvent;
	private CustomEventRunningLate runningLateEvent;
	private CustomEventShipped shippedEvent;
	private ApplicationEventPublisher createEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher createEventPublisher) {
		this.createEventPublisher = createEventPublisher;
	}
	
	//Publish Create Event
	public void publishCreate(){
		createEvent = new CustomEventCreated(this);
		this.createEventPublisher.publishEvent(createEvent);
		logger.debug("Publish Create Event");
	}
	
	//Publish Delivered Event
	public void publishDelivered(){
		deliveredEvent = new CustomEventDelivered(this);
		this.createEventPublisher.publishEvent(deliveredEvent);
		logger.debug("Publish Delivered Event");
	}
	
	//Publish Packed Event
	public void publishPacked(){
		packedEvent = new CustomEventPacked(this);
		this.createEventPublisher.publishEvent(packedEvent);
		logger.debug("Publish Packed Event");
	}
	
	//Publish Running Late Event
	public void publishRunningLate(){
		runningLateEvent = new CustomEventRunningLate(this);
		this.createEventPublisher.publishEvent(runningLateEvent);
		logger.debug("Publish Running Late Event");
	}
	
	//Publish Shipped Event
	public void publishShipped(){
		shippedEvent = new CustomEventShipped(this);
		this.createEventPublisher.publishEvent(shippedEvent);
		logger.debug("Publish Shipped Event");
	}
	
}
