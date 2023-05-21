package com.journey.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.journey.mapper.MeetMapper;
import com.journey.pojo.Meet;
import com.journey.service.MeetService;
import com.journey.util.SqlSessionFactoryUtils;

public class MeetServiceImpl implements MeetService{
	private SqlSessionFactory ssf=SqlSessionFactoryUtils.getSqlSessionFactory();
	@Override
	public List<Meet> selectAll() {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		MeetMapper mm=ss.getMapper(MeetMapper.class);
		List<Meet> meets=mm.selectAll();
		return meets;
	}

}
