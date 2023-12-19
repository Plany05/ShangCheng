package com.aaa.dao.impl;

import java.util.List;
import java.util.Map;

import com.aaa.dao.IUserDao;
import com.aaa.entity.User;
import com.aaa.util.DaoUtil;

public class UserDAOImpl implements IUserDao{
	/**
	 * 手机号唯一性校验
	 * @param telephone
	 * @return
	 */
	@Override
	public boolean isExist(String telephone) {
//		动态sql，查询电话是否已经注册过,查询对应电话是否在
		String sql = "select * from user where telephone = ?";
//		使用list，泛型为Map，Map泛型为String，Object接收调用DaoUtil工具类中executrQuery(sql,telephone)方法返回的结果集，
		List<Map<String,Object>> list = DaoUtil.executeQuery(sql, telephone);
//		返回的是布尔值，再返回前会判断list.size>0结果，是true返回true，是false返回false
		return list.size() > 0;
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@Override
	public int add(User user) {
//		动态sql，向user表中添加id，电话，密码，昵称和邮箱，id为空
		String sql = "insert into user values (null , ? , ? , ? , ?)";
//		返回调用DaoUtil.executeUpdate()方法的结果
		return DaoUtil.executeUpdate(sql, user.getTelephone() ,
				user.getPassword() , user.getNickname() , user.getEmail());
	}
	/**
	 * 登录
	 * @param telephone
	 * @param password
	 * @return
	 */
	@Override
	public Map<String, Object> isLogin(String telephone, String password) {
//		动态sql，查询user表中是否有对应电话和密码的用户信息
		String sql = "select * from user where telephone = ? and password = ?";
//		select * from user where telephone=15038096845 and password ='yyk'
//		调用DaoUtil中executeQuery()方法，执行sql，方法参数列表为sql，telephone，password
		List<Map<String,Object>> list = DaoUtil.executeQuery(sql, telephone , password);
//		list>0，证明用户信息存在数据库中
//		这个list的长度不会小于0.它要么大于零，证明用户输入的信息合法，即executerQuery方法查询到的对应的用户数据
//		要么它等于零，即证明用户输入的信息不合法，说明用户要么电话或者面膜输入错误，要么就没有注册
		if (list.size() > 0) {
//			从list中获取下标为0的用户信息并返回
			return list.get(0);
		}
//		查不到对应用户信息就返回空
		return null;
	}
	/**
	 * 修改登录密码
	 * @param telephone
	 * @param password
	 * @return
	 */
	@Override
	public int changePsw(String password,String uid) {
//		动态sql，更新user表的uid为用户id的password列
		String sql="update user set password=? where uid=?";
//		返回调用DaoUtil工具类中executeUpdate()的结果，参数列表，sql,password,uid
		return DaoUtil.executeUpdate(sql,password, uid);
	}
}
