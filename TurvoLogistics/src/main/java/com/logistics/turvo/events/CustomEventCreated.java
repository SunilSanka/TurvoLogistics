package com.logistics.turvo.events;

import org.springframework.context.ApplicationEvent;


public class CustomEventCreated extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomEventCreated(Object source) {
		super(source);
	}


}
