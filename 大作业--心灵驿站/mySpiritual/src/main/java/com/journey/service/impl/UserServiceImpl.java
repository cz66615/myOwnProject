package com.journey.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.journey.mapper.UserMapper;
import com.journey.pojo.User;
import com.journey.service.UserService;
import com.journey.util.SqlSessionFactoryUtils;

public class UserServiceImpl implements UserService{
	SqlSessionFactory ssf=SqlSessionFactoryUtils.getSqlSessionFactory();
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		UserMapper um=ss.getMapper(UserMapper.class);
		List<User> users=um.selectAll();
		ss.close();
		return users;
	}
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		UserMapper um=ss.getMapper(UserMapper.class);
		um.insertUser(user);
		ss.commit();
		ss.close();
	}
	@Override
	public List<User> selectUser(String username, String password) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		UserMapper um=ss.getMapper(UserMapper.class);
		List<User> users=um.selectUser(username, password);
		return users;
	}
	@Override
	public List<User> selectUserByName(String username) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		UserMapper um=ss.getMapper(UserMapper.class);
		List<User> users=um.selectUserByName(username);
		return users;
	}
	
}
