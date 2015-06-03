package com.logos.demo.dao;

import com.logos.demo.model.User;

public interface UserDao extends BaseDao<User, Long> {

	User findByName(String name);

	User findByEmail(String email);
}
