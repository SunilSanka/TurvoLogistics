package com.logistics.turvo;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.logistics.turvo.model.Users;
import com.logistics.turvo.repository.UserReposiroty;
import com.logistics.turvo.service.NotificationHelper;
import com.logistics.turvo.service.UserService;


public class UserServiceTest{
	
	@InjectMocks
	private UserService userService; 
	
	@Mock
	private UserReposiroty userRepo;
	
	@Mock
	private NotificationHelper helper;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipmentGetOne(){
	
	Users userMock = new Users();
	userMock.setUserId(200L);
	
	when(userRepo.findOne(200L)).thenReturn(userMock);
		
	Users userReturn = userRepo.findOne(200L);
	
	verify(userRepo).findOne(200L);
		
	assertThat(userReturn.getUserId(), is(200L));
		
	}
	
	@Test
	public void testShipmentGetAll(){
		
		Users userMock1 = new Users();
		userMock1.setUserId(200L);
		
		Users userMock2 = new Users();
		userMock2.setUserId(300L);
	
		List<Users> userList = new ArrayList<>();
		
		userList.add(userMock1);
		userList.add(userMock2);

		when(userRepo.findAll()).thenReturn(userList);
		
		
		List<Users> userReturnList = userService.getAllUsers();
		verify(userRepo).findAll();
		
		assertThat(userReturnList.size(), is(2));
		
	}
	
	@Test
	public void testShipmentSave(){
		
		Users userMock = new Users();
		userMock.setUserId(200L);
		userMock.setAadhar("123400004321");
	
		when(userRepo.save(userMock)).thenReturn(userMock);
		
		boolean userAdded = userService.addUser(userMock);
		
		verify(userRepo).save(userMock);
		verify(userRepo).findByAadhar("123400004321");
		
		assertThat(userAdded, is(true));
 }
	
	@Test
	public void testShipmentUpdate(){
		Users userMock = new Users();
		userMock.setUserId(200L);
		userMock.setAadhar("123400004321");
	
		when(userRepo.saveAndFlush(userMock)).thenReturn(userMock);
				
		boolean userAdded = userService.updateUser(userMock);
		verify(userRepo).saveAndFlush(userMock);
				
		assertThat(userAdded, is(true));
		
	}
	
	@Test
	public void testShipmentDelete(){
		
		doNothing().when(userRepo).delete(200L);
			
		userService.deleteUser(200L);
		
		verify(userRepo).delete(200L);
				
	}
	
}
