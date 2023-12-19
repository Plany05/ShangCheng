package com.aaa.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 反射机制
 * @author admin
 * baseServlet 反射机制确定
 */
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=UTF-8");
		String m = req.getParameter("m");
		try {
			Method method = this.getClass().getDeclaredMethod
					(m, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,req,resp);
		}catch (Exception e){
			e.printStackTrace();
		}
	}	
	
		
}
