package com.journey.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.journey.mapper.TopicMapper;
import com.journey.pojo.Topic;
import com.journey.service.TopicService;
import com.journey.util.SqlSessionFactoryUtils;

public class TopicServiceImpl implements TopicService{
	private SqlSessionFactory ssf=SqlSessionFactoryUtils.getSqlSessionFactory();
	@Override
	public void insertTopic(Topic topic) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		TopicMapper tm=ss.getMapper(TopicMapper.class);
		List<Topic> topics=tm.selectByUserName(topic.getUserName());
		if(topics.size()==0) {
			System.out.println("insert...");
			tm.insertTopic(topic);
			
		}else {
			System.out.println("update...");
			tm.updateTopic(topic);
			
		}
		ss.commit();
		ss.close();
	}
	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		TopicMapper tm=ss.getMapper(TopicMapper.class);
		tm.updateTopic(topic);
		ss.commit();
		ss.close();
	}
	@Override
	public List<Topic> selectByUserName(String userName) {
		// TODO Auto-generated method stub
		SqlSession ss=ssf.openSession();
		TopicMapper tm=ss.getMapper(TopicMapper.class);
		List<Topic> topics=tm.selectByUserName(userName);
		ss.close();
		return topics;
	}
	
}
