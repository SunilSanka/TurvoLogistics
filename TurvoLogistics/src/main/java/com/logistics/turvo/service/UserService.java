package com.logistics.turvo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.logistics.turvo.model.Users;
import com.logistics.turvo.repository.UserReposiroty;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserReposiroty userRepository;
		
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private NotificationHelper helper;
	
	@Override
	public boolean addUser(Users user) {
		if(userRepository.findByAadhar(user.getAadhar()) != null){
			return false;
		} else{
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			
			userRepository.save(user);
			
			helper.subscribe(user);
		}
		return true;
	}

	@Override
	public boolean updateUser(Users user) {
		if(user.getAadhar() != null){
			userRepository.saveAndFlush(user);
			helper.subscribe(user);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Users getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
}
