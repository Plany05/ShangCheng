package com.aaa.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;

import com.aaa.dao.IUserDao;
import com.aaa.dao.impl.UserDAOImpl;
import com.aaa.entity.Result;
import com.aaa.entity.User;
import com.aaa.util.AliyunCodeUtil;
import com.alibaba.fastjson.JSON;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private IUserDao dao = new UserDAOImpl();
	/*
	 * �޸�����
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void changePsw(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	/**
	 * ע��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	/**
	 * ��ȡ�û���Ϣ
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	/**
	 * ��¼ҵ��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
		//	1���û���ҳ���������û��������룬�����¼��ť������post����
		//	2������post������Я���Ĳ����������ֻ��š�����
		//	3������ֻ��ź�������д�����֤�û��Ϸ���
		//	4�������û��Ϸ��Խ���������������ǰ��
		//	��������httpserveletRequest��  req���
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//		����ս����
	Result result = new Result();
		//		��ȡtelephone
		//		ʹ��req.getParameter()��ȡǰ�������е��ֻ���
		//		ǰ�������еĲ��������Լ�ֵ�Եķ�ʽ���ڵ�
	String telephone = req.getParameter("telephone");
		//		��ȡpassword
	String password = req.getParameter("password");
		//		����dao��isLogin��������֤�û�������û����������Ƿ������ݿ��д���
		//		user��Ϊ�գ�֤���û��Ϸ�����¼�ɹ�
		//		user�գ�֤���û����Ϸ������¼���ֻ��Ż����룬����ȥע��
		Map<String, Object> user =  dao.isLogin(telephone,password);
		//		���Map user���Ϊ��
	if(user==null){
	result = new Result(20008,"�û���������������������¼�������ע��",null);
}
else{
	result = new Result(20009,"��¼�ɹ�",null);
	req.getSession().setAttribute("user",user);
}
	String jsonString = JSON.toJSONString(result);
	resp.getWriter().write(jsonString);
			//			����״̬��20008��msg�˺�������󣬸�������Ϣ

			//			����״̬��20009��msg��¼�ɹ�����������Ϣ

			//			����ѯ�����û���Ϣ����session,KV,"user",user

	    	//		�����ת��json

	    	//		����ǰ��

	}
	/**
	 * ������֤��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����ս����
		Result result = new Result();

		// 1 ��ȡ�û��������֤��code
		String userInputCode = req.getParameter("code");

		// ��session�л�ȡ����ʱ����session������֤����֤��
		String storedCode = (String) req.getSession().getAttribute("code");

		// ������ͬ
		if (userInputCode.equals(storedCode)) {
			// 2 ��֤�ֻ��ŵ�Ψһ��
			String telephone = req.getParameter("telephone");
			boolean isExist = dao.isExist(telephone);

			if (isExist) {
				// �ֻ����Ѿ���ע���
				result = new Result(20006, "�ֻ����ѱ�ռ��", null);
			} else {
				// �ֻ���û�б�ע���
				// ��ȡ����ע����Ϣ
				String password = req.getParameter("password");
				String nickname = req.getParameter("nickname");
				String email = req.getParameter("email");

				// �����µ�Userʵ����
				User newUser = new User();
				newUser.setTelephone(telephone);
				newUser.setPassword(password);
				newUser.setNickname(nickname);
				newUser.setEmail(email);

				// ����dao��add���������ݿ�������û���Ϣ
				int rowsAffected = dao.add(newUser);


				if (rowsAffected>0) {
					// ע��ɹ�
					result = new Result(20007, "ע��ɹ�", null);
				} else {
					// ע��ʧ��
					result = new Result(50000, "ע��ʧ�ܣ����Ժ�����", null);
				}
			}
		} else {
			// ��֤�벻��ȷ
			result = new Result(20005, "��֤�����", null);
		}

		// �����ת��json
		String jsonString = JSON.toJSONString(result);

		// ����ǰ��
		resp.getWriter().write(jsonString);

	}
	/**
	 * ��֤��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sendCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��req�л�ȡ�ֻ���tel
		String telephone = req.getParameter("tel");

		// 2 ����AliyunCodeUtil.sendCode������ģ�⣩������֤��
		String generatedCode = AliyunCodeUtil.sendCode(telephone); // ������Ҫ�����ʵ������滻�ɷ�����֤���ʵ���߼�

		// 3 ����֤��洢��session�� �Թ�����У��ʹ��  KV = "code",code
		req.getSession().setAttribute("code", generatedCode);

		// ��ӡcode
		System.out.println("Generated Code: " + generatedCode);

		// 4 ����״̬��20004��msg���ŷ��ͳɹ�����������Ϣ
		Result result = new Result(20004, "���ŷ��ͳɹ�", null);

		// �����ת��json
		String jsonString = JSON.toJSONString(result);

		// ����ǰ��
		resp.getWriter().write(jsonString);

	}
}
