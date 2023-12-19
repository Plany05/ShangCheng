package com.aaa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.entity.Result;
import com.alibaba.fastjson.JSON;
/**
 * 过滤器
 * @author admin
 *
 */
@WebFilter("/foo/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain c)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object user = req.getSession().getAttribute("user");
		
		if (user == null) {
			resp.setContentType("text/json;charset=utf-8");
			Result result = new Result(20011, "对不起   请先登录", null);
			String jsonString = JSON.toJSONString(result);
			resp.getWriter().write(jsonString);
		}else {
			c.doFilter(req, resp);
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
