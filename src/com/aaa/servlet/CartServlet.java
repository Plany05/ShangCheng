package com.aaa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.ICartDao;
import com.aaa.dao.impl.CartDaoImpl;
import com.aaa.entity.Car;
import com.aaa.entity.Result;
import com.aaa.util.ImputedPriceUtil;
import com.alibaba.fastjson.JSON;

@WebServlet("/foo/cart")
public class CartServlet extends BaseServlet{
	private ICartDao dao = new CartDaoImpl();

	protected void plusNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");
		Object uid = user.get("uid");
		String pid = req.getParameter("pid");
		List<Map<String, Object>> list = dao.plusNum(uid.toString(), pid);
		ImputedPriceUtil data = new ImputedPriceUtil(list);
		
		Result result = new Result(20026, "��������ɹ�", data);
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void reduceNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");
		Object uid = user.get("uid");
		String pid = req.getParameter("pid");
		List<Map<String, Object>> list = dao.reduceNum(uid.toString(), pid);
		
		ImputedPriceUtil data = new ImputedPriceUtil(list);
		
		Result result = new Result(20027, "���������ɹ�", data);
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}
	

	protected void deleteOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String,Object> user = (Map<String, Object>) req.getSession().getAttribute("user");
		Object uid = user.get("uid");
		
		String id = req.getParameter("id");

		List<Map<String, Object>> data = dao.delete(Integer.parseInt(id), uid);

		ImputedPriceUtil list = new ImputedPriceUtil(data);
		
		Result result = new Result(20010, "ɾ����Ϣ�ɹ�", list);
		
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		Result result = null;
		List<Map<String, Object>> date = dao.deleteAll(uid);
		if (date!=null) {
			ImputedPriceUtil list = new ImputedPriceUtil(date);
			 result = new Result(20014, "ɾ����Ϣ�ɹ�", list);
		} else {
			result = new Result(20015, "ɾ����Ϣʧ��", null);
		}
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = null;
		String pid = req.getParameter("pid");
		String pname = req.getParameter("pname");
		String pimage = req.getParameter("pimage");
		String shopPrice = req.getParameter("shopPrice");
		String num = req.getParameter("num");
		
		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");
		
		Object uid = user.get("uid");
		
		 boolean i = dao.isExistProduct(String.valueOf(uid), pid);
		 if(i==true) {
			 int addNum = dao.addNum(String.valueOf(uid), pid);
			 result = new Result(20030, "���Ѿ���ӹ��� ������1", null);
		 }else {
		Car car = new Car(0, String.valueOf(uid), pid, pname, pimage, shopPrice, num);

		int a = dao.addCart(car);
		
		result = new Result(20012, "��ӹ��ﳵ�ɹ�", null);
		 }
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
 
	}

	protected void getUserCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> user = (Map<String, Object>) req.getSession().getAttribute("user");
		Object uid = user.get("uid");
		List<Map<String, Object>> data = dao.getUserCart(uid);
		ImputedPriceUtil list = new ImputedPriceUtil(data);
		Result result = new Result(20013, "��ȡ�ɹ�", list);
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}
	
}
