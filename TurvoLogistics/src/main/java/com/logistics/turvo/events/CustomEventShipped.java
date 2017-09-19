package com.logistics.turvo.events;

import org.springframework.context.ApplicationEvent;

public class CustomEventShipped extends ApplicationEvent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	public CustomEventShipped(Object source) {
		super(source);
	}
}
