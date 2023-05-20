package com.journey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.journey.pojo.User;

public interface UserMapper {
	List<User> selectAll();
	void insertUser(User user);
	List<User> selectUserByName(@Param("username") String username);
	List<User> selectUser(@Param("username") String username,@Param("password") String password);
}
