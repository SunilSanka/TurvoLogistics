package com.logistics.turvo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.logistics.turvo.model.Users;
import com.logistics.turvo.repository.UserReposiroty;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

	@Autowired
	private UserReposiroty userRepository;
	
	
	
	@Test
	public void findShipments(){
		List<Users> userList = userRepository.findAll();
		assertThat(userList.size(), is(greaterThan(0)));
	}
	
	@Test
	public void findShipmentById(){
		Users user = userRepository.findOne(101L);
		assertThat(user.getAadhar(), is("123456784321"));
	}
		
	@Test(expected=DataIntegrityViolationException.class)
	public void addUserFalied(){
		Users user = new Users();
		user.setName("Integration Test User");
		user.setAadhar("123456784321");
		
		Users savedUser = userRepository.save(user);
		assertThat(savedUser, null);
	}
	
	@Test
	public void addUser(){
		Users user = new Users();
		user.setName("Integration Test User");
		user.setAadhar("123400004321");
		
		Users savedUser = userRepository.save(user);
		assertThat(savedUser.getUserId(), is(104L));
	}
	
	@Test
	public void findByAadhar(){
		Users savedUser = userRepository.findByAadhar("123456784321");
		assertThat(savedUser.getUserId(), is(101L));
	}

	@Test(expected=NullPointerException.class)
	public void findByAadharUserFail(){
		Users savedUser = userRepository.findByAadhar("123400004321");
		assertThat(savedUser.getUserId(), null);
	}

	@Test(expected=NullPointerException.class)
	public void deleteShipment(){
		Users savedUser1 = userRepository.findByAadhar("123456784321");
		assertThat(savedUser1.getUserId(), is(101L));
		userRepository.delete(101L);
		Users savedUser2 = userRepository.findByAadhar("123400004321");
		assertThat(savedUser2.getUserId(), null);
	}
}
