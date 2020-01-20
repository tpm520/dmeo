package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper um;
	@Override
	public List<User> findUserAll() {
		List<User> users = um.findUserAll();
		return users;
	}
	@Override
	public Integer addUser(User user) {
		Integer info = um.addUser(user);
		return info;
	}

}
