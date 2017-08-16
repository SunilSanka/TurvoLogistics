package com.logistics.turvo.service;


import java.util.List;

import com.logistics.turvo.model.Event;

public interface IEventService {

	boolean addEvent(Event event);

	void updateEvent(Event event);

	List<Event> getAllEvents();

	Event getEventById(Long id);

	void deleteEvent(Long id);

}
