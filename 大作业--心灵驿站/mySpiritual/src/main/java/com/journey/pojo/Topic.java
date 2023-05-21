package com.journey.pojo;

public class Topic {
	private String userName;
	private int num;
	private String topicName;
	@Override
	public String toString() {
		return "Topic [userName=" + userName + ", num=" + num + ", topicName=" + topicName + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Topic(String userName, int num, String topicName) {
		super();
		this.userName = userName;
		this.num = num;
		this.topicName = topicName;
	}
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
}
