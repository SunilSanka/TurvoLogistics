package com.logistics.turvo.events;

import org.springframework.context.ApplicationEvent;

public class CustomEventRunningLate extends ApplicationEvent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public CustomEventRunningLate(Object source) {
		super(source);
	}

}
