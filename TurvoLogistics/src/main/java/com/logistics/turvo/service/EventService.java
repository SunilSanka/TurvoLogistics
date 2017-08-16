package com.logistics.turvo.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistics.turvo.model.Event;
import com.logistics.turvo.repository.EventReposiroty;

@Service
@Transactional
public class EventService implements IEventService {

	@Autowired
	private EventReposiroty eventRepository;
	
	@Override
	public boolean addEvent(Event event) {
		if(eventRepository.exists(event.getId())){
			return false;
		}else{
			eventRepository.saveAndFlush(event);
		}
		return true;
	}

	@Override
	public void updateEvent(Event event) {
		eventRepository.saveAndFlush(event);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event getEventById(Long id) {
		return eventRepository.findOne(id);
	}

	@Override
	public void deleteEvent(Long id) {
		eventRepository.delete(id);
	}
}
