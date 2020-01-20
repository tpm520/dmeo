package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {
	// 查询所有用户
	public List<User> findUserAll();
	// 添加用户
	public Integer addUser(User user);
}
