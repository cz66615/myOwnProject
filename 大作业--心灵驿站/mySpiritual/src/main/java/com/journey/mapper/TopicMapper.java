package com.journey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.journey.pojo.Topic;

public interface TopicMapper {
	List<Topic> selectByUserName(@Param("userName") String userName);
	void insertTopic(Topic topic);
	void updateTopic(Topic topic);
}
