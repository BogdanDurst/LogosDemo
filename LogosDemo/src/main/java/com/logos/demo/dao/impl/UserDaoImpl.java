package com.logos.demo.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logos.demo.dao.UserDao;
import com.logos.demo.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Transactional
	public User findByName(String name) {
		try {
			return (User) entityManager.createNamedQuery(User.FIND_BY_NAME)
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public User findByEmail(String email) {
		try {
			return (User) entityManager.createNamedQuery(User.FIND_BY_EMAIL)
					.setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
