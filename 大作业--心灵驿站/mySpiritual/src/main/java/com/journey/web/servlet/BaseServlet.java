package com.journey.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获得请求资源路径
		String uri=req.getRequestURI();
		int index=uri.lastIndexOf("/");
		
		//获得二级路径(方法名)
		String methodName=uri.substring(index+1);//左闭右开舍左闭
		System.out.println(methodName);
		
		//获得当前Servlet的字节码对象
		Class<? extends BaseServlet> cls=this.getClass();	
		
		//获取方法对象
		try {
			Method method=cls.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//调用方法
			method.invoke(this,req,resp );
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
