package com.journey.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journey.pojo.Topic;
import com.journey.service.impl.TopicServiceImpl;

@WebServlet("/topic/*")
public class TopicServlet extends BaseServlet{
	private TopicServiceImpl tsi=new TopicServiceImpl();
	private String[] topicName=new String[]{"学习","适应","改变","爱"};
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void insertTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		int index=Integer.parseInt(request.getParameter("index"));
		Cookie[] cookies=request.getCookies();
		String username;
		String value="";
		for(Cookie cookie:cookies) {
			username=cookie.getName();
			if("username".equals(username)) {
				value=cookie.getValue(); 
			}
		}
		Topic topic=new Topic(value,index,topicName[index-1]);
		tsi.insertTopic(topic);
	}
}

