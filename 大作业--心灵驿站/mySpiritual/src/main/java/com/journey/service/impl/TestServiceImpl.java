package com.journey.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.journey.mapper.TestMapper;
import com.journey.pojo.Test;
import com.journey.service.TestService;
import com.journey.util.SqlSessionFactoryUtils;

public class TestServiceImpl implements TestService{
	private SqlSessionFactory ssf=SqlSessionFactoryUtils.getSqlSessionFactory();
	@Override
	public void insertTest(Test test) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		TestMapper ts=ss.getMapper(TestMapper.class);
		ts.deleteTest(test);
		ts.insertTest(test);
		ss.commit();
		ss.close();
	}
	@Override
	public void deleteTest(Test test) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		TestMapper ts=ss.getMapper(TestMapper.class);
		ts.deleteTest(test);
		ss.commit();
		ss.close();
	}

}
