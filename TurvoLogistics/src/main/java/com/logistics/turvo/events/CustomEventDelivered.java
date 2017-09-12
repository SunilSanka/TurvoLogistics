package com.logistics.turvo.events;

import org.springframework.context.ApplicationEvent;

public class CustomEventDelivered extends ApplicationEvent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public CustomEventDelivered(Object source) {
		super(source);
	}
}
