package com.logistics.turvo.events;

import org.springframework.context.ApplicationEvent;

public class CustomEventPacked extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public CustomEventPacked(Object source) {
		super(source);
	}
}
