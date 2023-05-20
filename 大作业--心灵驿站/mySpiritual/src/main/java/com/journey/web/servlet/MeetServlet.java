package com.journey.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.journey.pojo.Meet;
import com.journey.service.impl.MeetServiceImpl;

@WebServlet("/meet/*")
public class MeetServlet extends BaseServlet{
	private MeetServiceImpl msi=new MeetServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void getPages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pages...");
		String value="";
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies) {
			String name=cookie.getName();
			if("age".equals(name)) {
				value=cookie.getValue();
			}
		}
		int age=Integer.parseInt(value);
		System.out.println(age);
		int pages=4;
		if(age>=14) {
			pages=4;
		}else if(age>=11) {
			pages=3;
		}else if(age>=2) {
			pages=2;
		}else {
			pages=1;
		}
		response.getWriter().write(String.valueOf(pages));
	}
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selectAll...");
		List<Meet> meets=msi.selectAll();
		String jsonString=JSON.toJSONString(meets);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonString);
	}
	
}
