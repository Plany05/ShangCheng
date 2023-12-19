package com.aaa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.IProductDAO;
import com.aaa.dao.impl.ProductDAOImpl;
import com.aaa.entity.Result;
import com.alibaba.fastjson.JSON;

@WebServlet("/pro")
public class ProductServlet extends BaseServlet {

	Result result = null;

	private static final long serialVersionUID = 1L;
	private IProductDAO dao = new ProductDAOImpl();

	protected void jacket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cid = req.getParameter("cid");
		List<Map<String, Object>> jacket = dao.getJacket(Integer.parseInt(cid));
		Result result = new Result(20008, "��ȡ������Ϣ�ɹ�", jacket);
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void getProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);

		Map<String, Object> map = dao.getProductByID(id);
		if (map == null) {
			result = new Result(20002, "�Բ���  ��Ʒ��ȡʧ��", null);
		} else {
			result = new Result(20003, "��Ʒ��ȡ�ɹ�", map);
		}
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}

	protected void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String page = req.getParameter("page");

		String name = req.getParameter("name");

		Map<String, Object> data = dao.getProduct(page, name);
		if (data != null) {
			result = new Result(20001, "��ȡ��ҳ��Ϣ�ɹ�", data);
		} else {
			result = new Result(20002, "��ȡ��ҳ��Ϣʧ��", data);
		}
		String jsonString = JSON.toJSONString(result);
		resp.getWriter().write(jsonString);
	}
}
