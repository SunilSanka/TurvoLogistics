package com.logistics.turvo.notification.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShipmentDeliveredService{
	
	@Autowired
	private NotifyAction action;
	
	public Set<Long> subUsers = new TreeSet<Long>();

	public Set<Long> getSubUsers() {
		return subUsers;
	}

	public void sendNotification(String message) {
		action.setMessage(message);
		subUsers.forEach(action);
	}

}
