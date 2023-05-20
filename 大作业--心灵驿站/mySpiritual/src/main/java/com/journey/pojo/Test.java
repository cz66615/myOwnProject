package com.journey.pojo;

public class Test {
	private int num;
	private String userName;
	private String result;
	@Override
	public String toString() {
		return "Test [num=" + num + ", username=" + userName + ", result=" + result + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test(int num, String username, String result) {
		super();
		this.num = num;
		this.userName = username;
		this.result = result;
	}
}
