package com.aaa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.impl.ProductDAOImpl;
import com.alibaba.fastjson.JSON;

@WebServlet("/index/*")
public class IndexServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		String url = request.getParameter("url");
		try {
			this.getClass().getDeclaredMethod(url, HttpServletRequest.class,
					HttpServletResponse.class).invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void topmenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		ProductDAOImpl daoImper = new ProductDAOImpl();
		List<Map<String, Object>> list = daoImper.topmenu();
		String tojsonString = JSON.toJSONString(list);
		response.getWriter().write(tojsonString);
	}

	protected void lefttopmenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		ProductDAOImpl daoImper = new ProductDAOImpl();
		List<Map<String, Object>> list = daoImper.lefttopmenu();
		String tojsonString = JSON.toJSONString(list);
		response.getWriter().write(tojsonString);
	}

	protected void centerProducts(HttpServletRequest request,
								  HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		ProductDAOImpl daoImper = new ProductDAOImpl();
		Map<String, Object> list = daoImper.centerProducts();
		String tojsonString = JSON.toJSONString(list);
		response.getWriter().write(tojsonString);
	}
}
