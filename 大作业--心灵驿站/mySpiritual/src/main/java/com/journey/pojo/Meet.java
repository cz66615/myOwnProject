package com.journey.pojo;

public class Meet {
	private String userName;
	private int age;
	private int stage;
	private String phenomenon;
	@Override
	public String toString() {
		return "Meet [userName=" + userName + ", age=" + age + ", stage=" + stage + ", phenomenon=" + phenomenon + "]";
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
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public String getPhenomenon() {
		return phenomenon;
	}
	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
	}
	public Meet(String userName, int age, int stage, String phenomenon) {
		super();
		this.userName = userName;
		this.age = age;
		this.stage = stage;
		this.phenomenon = phenomenon;
	}
	public Meet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
