package com.aaa.dao;

import java.util.Map;

import com.aaa.entity.User;

public interface IUserDao {
	/**
	 * 电话号码的唯一型校验
	 * @param telephone
	 * @return
	 */
//	boolean返回值 isExist() 参数列表：String telephone
	boolean isExist(String telephone);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	int add(User user);

	/**
	 * 用户登录
	 * @param telephone
	 * @param password
	 * @return
	 */
//	Map<String,Object>返回值 isLogin() 参数列表String telephone,password
	Map<String, Object> isLogin(String telephone, String password);
//	int返回值 changePsw() 参数列表 String password,uid
	int changePsw(String password, String uid);
	
}
