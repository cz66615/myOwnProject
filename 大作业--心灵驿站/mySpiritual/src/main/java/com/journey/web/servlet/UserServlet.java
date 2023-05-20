package com.journey.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journey.pojo.User;
import com.journey.service.impl.UserServiceImpl;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
	private UserServiceImpl usi=new UserServiceImpl();
	private String prefix="425129221";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("user login...");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String result="";		
		List<User> users=usi.selectUserByName(username);
		if(users.size()>0)
		{
			User user=users.get(0);
			if(user.getPassword().equals(password)) {
				result="success";
				Cookie cookie1=new Cookie("username",username);
				cookie1.setPath("/");
				Cookie cookie2=new Cookie("age",String.valueOf(user.getAge()));
				cookie2.setPath("/");
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			else
				result="errpassword";
		}
		else
		{
			result="errusername";
		}
		response.getWriter().write(result);
	}
	

	public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userName=request.getParameter("username");
		List<User> user=usi.selectUserByName(userName);
		if(user.size()>0)
		{
			response.getWriter().write("duplicate");
		}
		else
		{
			List<User> users=usi.selectAll(); 
			int total=users.size()+1;
			String password=request.getParameter("password");
			String age=request.getParameter("age");
			String sex=request.getParameter("sex");
			String userId=prefix+age+total;
			User newUser=new User(userId,userName,password,Integer.parseInt(age),sex);
			System.out.print(newUser);
			usi.insertUser(newUser);
			response.getWriter().write("success");
		}
	}
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("user selectAll...");
	}
	
}
