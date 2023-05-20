package com.journey.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journey.pojo.Consult;
import com.journey.service.impl.ConsultServiceImpl;

@WebServlet("/consult/*")
public class ConsultServlet extends BaseServlet{
	private ConsultServiceImpl csi=new ConsultServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void insertConsult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userName=request.getParameter("userName");
		String age=request.getParameter("age");
		String time=request.getParameter("time");
		String content=request.getParameter("content");
		String contact=request.getParameter("contact");
		Consult consult=new Consult(userName,Integer.parseInt(age),time,content,contact);
		csi.deleteConsult(consult);
		csi.insertConsult(consult);
		response.getWriter().write("success");
	}
	public void getUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		Cookie[] cookies=request.getCookies();
		String userName="";
		for(Cookie cookie:cookies) {
			String name=cookie.getName();
			if("username".equals(name)) {
				userName=cookie.getValue();
			}
		}
		response.getWriter().write(userName);
	}
}
