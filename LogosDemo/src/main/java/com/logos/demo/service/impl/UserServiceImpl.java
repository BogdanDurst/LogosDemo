package com.logos.demo.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.logos.demo.dao.UserDao;
import com.logos.demo.model.User;
import com.logos.demo.service.UserService;

@Secured("ROLE_USER")
@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	@Transactional
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@Transactional
	public User getUserInfo(long userId) {
		User user = userDao.findById(userId);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}

	@Transactional
	public void saveUser(String userName, String email, String password) {
		userDao.save(new User(userName, email, password));
	}

	@Transactional
	public User getUserInfoByEmail(String email) {
		User user = userDao.findByEmail(email);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}

	@Transactional
	public User getUserInfoByName(String name) {
		User user = userDao.findByName(name);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}

}