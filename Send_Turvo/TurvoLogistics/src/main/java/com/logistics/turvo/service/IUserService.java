package com.logistics.turvo.service;


import java.util.List;

import com.logistics.turvo.model.Users;

public interface IUserService {

	boolean addUser(Users user);

	boolean updateUser(Users user);

	List<Users> getAllUsers();

	Users getUserById(Long id);

	void deleteUser(Long id);

}
