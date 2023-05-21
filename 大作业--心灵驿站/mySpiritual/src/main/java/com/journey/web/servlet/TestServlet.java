package com.journey.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journey.pojo.Test;
import com.journey.service.impl.TestServiceImpl;

@WebServlet("/test/*")
public class TestServlet extends BaseServlet{
	private TestServiceImpl tsi=new TestServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void insertTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String num=request.getParameter("num");
		System.out.println(num);
		String result=request.getParameter("result");
		Cookie[] cookies=request.getCookies();
		String userName="";
		for(Cookie cookie:cookies) {
			String name=cookie.getName();
			if("username".equals(name)) {
				userName=cookie.getValue();
			}
		}
		Test test=new Test(Integer.parseInt(num),userName,result);
		System.out.println(test);
		tsi.insertTest(test);
	}
}
