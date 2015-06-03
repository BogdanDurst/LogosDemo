package com.logos.demo.service;

import java.util.List;

import com.logos.demo.model.User;


public interface UserService {

	List<User> getAllUsers();
	
	User getUserInfo(long userId);
	
	void saveUser(String userName, String email, String password);
	
	User getUserInfoByEmail(String email);
	
	User getUserInfoByName(String name);
	
}
