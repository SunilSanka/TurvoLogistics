package com.logistics.turvo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String eventName;

	public String getEventName() {
		return eventName;
	}

	public Long getId() {
		return Id;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
