package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	// 查询所有用户
	@Select("SELECT * FROM users")
	public List<User> findUserAll();
	// 添加用户
	@Insert("INSERT INTO users(username) VALUE(#{username})")
	public Integer addUser(User user);
}
