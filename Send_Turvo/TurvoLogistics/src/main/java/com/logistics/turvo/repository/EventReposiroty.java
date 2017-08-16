package com.logistics.turvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.turvo.model.Event;

@Repository
public interface EventReposiroty extends JpaRepository<Event, Long> {

}
