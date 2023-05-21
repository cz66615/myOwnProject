package com.journey.service;

import java.util.List;

import com.journey.pojo.Topic;

public interface TopicService {
	public List<Topic> selectByUserName(String userName);
	public void insertTopic(Topic topic);
	public void updateTopic(Topic topic);
}
