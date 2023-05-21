package com.journey.pojo;

public class Consult {
	private String userName;
	private int age;
	private String time;
	private String content;
	private String contact;
	@Override
	public String toString() {
		return "Consult [userName=" + userName + ", age=" + age + ", time=" + time + ", content=" + content
				+ ", contact=" + contact + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Consult(String userName, int age, String time, String content, String contact) {
		super();
		this.userName = userName;
		this.age = age;
		this.time = time;
		this.content = content;
		this.contact = contact;
	}
	public Consult() {
		super();
		// TODO Auto-generated constructor stub
	}
}
