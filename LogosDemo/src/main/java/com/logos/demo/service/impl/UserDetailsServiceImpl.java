package com.logos.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.demo.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Inject
	private UserDao userDao;

	@Transactional
	public UserDetails loadUserByUsername(String email) {

		com.logos.demo.model.User userEntity = userDao.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException("Error in email, or password");

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new User(userEntity.getId().toString(), userEntity.getPassword(), authorities);
	}
}
