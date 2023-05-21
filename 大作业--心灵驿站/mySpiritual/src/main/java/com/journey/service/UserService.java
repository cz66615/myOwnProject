package com.journey.service;

import java.util.List;

import com.journey.pojo.User;

public interface UserService {
	public List<User> selectAll();
	public void insertUser(User user);
	public List<User> selectUser(String username,String password);
	public List<User> selectUserByName(String username);
}
