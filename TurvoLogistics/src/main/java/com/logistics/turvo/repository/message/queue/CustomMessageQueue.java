package com.logistics.turvo.repository.message.queue;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

@Component
public class CustomMessageQueue {
	private LinkedList<String> shipmentCreateQueue = new LinkedList<String>();
	private LinkedList<String> shipmentDeliveredQueue = new LinkedList<String>();
	private LinkedList<String> shipmentPackedQueue = new LinkedList<String>();
	private LinkedList<String> shipmentRunningLateQueue = new LinkedList<String>();
	private LinkedList<String> shipmentShippedQueue = new LinkedList<String>();
	
	public LinkedList<String> getShipmentCreateQueue() {
		return shipmentCreateQueue;
	}
	public LinkedList<String> getShipmentDeliveredQueue() {
		return shipmentDeliveredQueue;
	}
	public LinkedList<String> getShipmentPackedQueue() {
		return shipmentPackedQueue;
	}
	public LinkedList<String> getShipmentRunningLateQueue() {
		return shipmentRunningLateQueue;
	}
	public LinkedList<String> getShipmentShippedQueue() {
		return shipmentShippedQueue;
	}


}
