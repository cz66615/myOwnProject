package com.journey.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.journey.mapper.ConsultMapper;
import com.journey.pojo.Consult;
import com.journey.service.ConsultService;
import com.journey.util.SqlSessionFactoryUtils;

public class ConsultServiceImpl implements ConsultService{
	private SqlSessionFactory ssf=SqlSessionFactoryUtils.getSqlSessionFactory();
	@Override
	public void insertConsult(Consult consult) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		ConsultMapper cm=ss.getMapper(ConsultMapper.class);
		cm.deleteConsult(consult);
		cm.insertConsult(consult);
		ss.commit();
		ss.close();
	}

	@Override
	public void deleteConsult(Consult consult) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		ConsultMapper cm=ss.getMapper(ConsultMapper.class);
		cm.deleteConsult(consult);
		ss.commit();
		ss.close();
	}

}
