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
	 * 修改密码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void changePsw(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	/**
	 * 注销
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	/**
	 * 获取用户信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	/**
	 * 登录业务
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
		//	1、用户在页面中输入用户名和密码，点击登录按钮，发送post请求
		//	2、接受post请求中携带的参数，接收手机号、密码
		//	3、针对手机号和密码进行处理，验证用户合法性
		//	4、根据用户合法性结果，将结果集返回前端
		//	请求是在httpserveletRequest中  req里边
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//		定义空结果集
	Result result = new Result();
		//		获取telephone
		//		使用req.getParameter()获取前端请求中的手机号
		//		前端请求中的参数，是以键值对的方式存在的
	String telephone = req.getParameter("telephone");
		//		获取password
	String password = req.getParameter("password");
		//		调用dao层isLogin方法，验证用户输入的用户名和密码是否在数据库中存在
		//		user不为空，证明用户合法，登录成功
		//		user空，证明用户不合法，重新检查手机号或密码，或者去注册
		Map<String, Object> user =  dao.isLogin(telephone,password);
		//		如果Map user结果为空
	if(user==null){
	result = new Result(20008,"用户名或密码输入错误，请重新检查或者请注册",null);
}
else{
	result = new Result(20009,"登录成功",null);
	req.getSession().setAttribute("user",user);
}
	String jsonString = JSON.toJSONString(result);
	resp.getWriter().write(jsonString);
			//			返回状态码20008和msg账号密码错误，附带空信息

			//			返回状态码20009和msg登录成功，附带空信息

			//			将查询到的用户信息存入session,KV,"user",user

	    	//		结果集转换json

	    	//		返回前端

	}
	/**
	 * 发送验证码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 定义空结果集
		Result result = new Result();

		// 1 获取用户输入的验证码code
		String userInputCode = req.getParameter("code");

		// 从session中获取发送时存入session用于验证的验证码
		String storedCode = (String) req.getSession().getAttribute("code");

		// 二者相同
		if (userInputCode.equals(storedCode)) {
			// 2 验证手机号的唯一性
			String telephone = req.getParameter("telephone");
			boolean isExist = dao.isExist(telephone);

			if (isExist) {
				// 手机号已经被注册过
				result = new Result(20006, "手机号已被占用", null);
			} else {
				// 手机号没有被注册过
				// 获取其他注册信息
				String password = req.getParameter("password");
				String nickname = req.getParameter("nickname");
				String email = req.getParameter("email");

				// 创建新的User实体类
				User newUser = new User();
				newUser.setTelephone(telephone);
				newUser.setPassword(password);
				newUser.setNickname(nickname);
				newUser.setEmail(email);

				// 调用dao层add方法向数据库中添加用户信息
				int rowsAffected = dao.add(newUser);


				if (rowsAffected>0) {
					// 注册成功
					result = new Result(20007, "注册成功", null);
				} else {
					// 注册失败
					result = new Result(50000, "注册失败，请稍后重试", null);
				}
			}
		} else {
			// 验证码不正确
			result = new Result(20005, "验证码错误", null);
		}

		// 结果集转换json
		String jsonString = JSON.toJSONString(result);

		// 返回前端
		resp.getWriter().write(jsonString);

	}
	/**
	 * 验证码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sendCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从req中获取手机号tel
		String telephone = req.getParameter("tel");

		// 2 调用AliyunCodeUtil.sendCode方法（模拟）发送验证码
		String generatedCode = AliyunCodeUtil.sendCode(telephone); // 这里需要你根据实际情况替换成发送验证码的实际逻辑

		// 3 将验证码存储到session中 以供后期校验使用  KV = "code",code
		req.getSession().setAttribute("code", generatedCode);

		// 打印code
		System.out.println("Generated Code: " + generatedCode);

		// 4 返回状态码20004和msg短信发送成功，附带空信息
		Result result = new Result(20004, "短信发送成功", null);

		// 结果集转换json
		String jsonString = JSON.toJSONString(result);

		// 返回前端
		resp.getWriter().write(jsonString);

	}
}
