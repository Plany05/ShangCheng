package com.aaa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.ICollectDAO;
import com.aaa.dao.impl.CollectDaoImpl;
import com.aaa.entity.Collect;
import com.aaa.entity.Result;
import com.alibaba.fastjson.JSON;
@WebServlet("/foo/collect")
public class CollectServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
	private ICollectDAO dao = new CollectDaoImpl();

	protected void deleteCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pid = req.getParameter("pid");

		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");

		Object uid = user.get("uid");

		int i = dao.deleteOne(pid, String.valueOf(uid));

		int reduceProductNum = dao.reduceProductNum(pid);

		Result result = new Result(20019, "ɾ���ɹ�", null);
		
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void getCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");

		Object uid = user.get("uid");

		List<Map<String, Object>> data = dao.getUserCollect(uid);

		Result result = new Result(20018, "��ȡ�ɹ�", data);

		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void collect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Result result =null;

		String pid = req.getParameter("pid");

		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");

		Object uid = user.get("uid");

		boolean i = dao.isExist(Integer.parseInt(pid),String.valueOf(uid));

		if(i==false) {

			result = new Result(20021, "���Ѿ���ӹ���", null);
		}else {

			int addProductNum = dao.addProductNum(pid);
			Collect collect = new Collect(0, Integer.parseInt(pid),String.valueOf(uid));
			int a=dao.productCollect(collect);
			result = new Result(20017, "��ӳɹ�", null);
		}
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}
}
