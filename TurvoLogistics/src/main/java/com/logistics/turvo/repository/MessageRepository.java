package com.logistics.turvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.logistics.turvo.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{

}
