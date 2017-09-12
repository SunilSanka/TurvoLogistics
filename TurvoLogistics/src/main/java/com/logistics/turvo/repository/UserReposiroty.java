package com.logistics.turvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.turvo.model.Users;

@Repository
public interface UserReposiroty extends JpaRepository<Users, Long> {
	
	Users findByAadhar(String aadhar);
	
}
