package com.aaa.dao.impl;

import java.util.List;
import java.util.Map;

import com.aaa.dao.IOderDAO;
import com.aaa.entity.Order;
import com.aaa.util.DaoUtil;

public class OrderDAOImpl implements IOderDAO {
	/**
	 * 提交商品详情订单
	 */
	@Override
	public int addOrder(Order order) {
		int serial = (int) (Math.random()*100000);
		String sql = "INSERT INTO  " + "tordernumber(uid,pid,tradeNum,province,city,county,site,phone,consigneeName,serial)  "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)  ";
		return DaoUtil.executeUpdate(sql, order.getUid(), order.getPid(), order.getTradeNum(), order.getProvince(),
				order.getCity(), order.getCounty(), order.getSite(), order.getPhone(), order.getConsigneeName(),serial);
	}
	/**
	 * 提交购物车订单
	 */
	@Override
	public int addOrders(Order order) {
		String sql = "select * from car where uid=?";
		List<Map<String, Object>> list = DaoUtil.executeQuery(sql, order.getUid());
		int serial = (int) (Math.random()*100000);
		for (Map<String, Object> map : list) {
			String pid = (String) map.get("pid");
			String num = (String) map.get("num");
			String sql3="update product set quantity=quantity+? where pid=?";
			DaoUtil.executeUpdate(sql3,num,pid);
			String sql2 = "INSERT INTO  "
					+ "tordernumber(uid,pid,tradeNum,province,city,county,site,phone,consigneeName,serial)  "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)  ";
			DaoUtil.executeUpdate(sql2, order.getUid(), pid, num, order.getProvince(), order.getCity(),
					order.getCounty(), order.getSite(), order.getPhone(), order.getConsigneeName(),serial);
		}
		
		String sql3 = "delete from car where uid=?";
		DaoUtil.executeUpdate(sql3, order.getUid());
		List<Map<String, Object>> list2 = DaoUtil.executeQuery(sql, order.getUid());
		if (list2.size() > 0) {
			return 1;
		}
		return 0;
	}
	/**
	 * 根据uid获取订单信息
	 */
	@Override
	public List<Map<String, Object>> getMyOrders(String uid) {
		String sql=" select distinct serial,addTime,phone,province,city,county,site,consigneeName from tordernumber where uid=? ";
		return DaoUtil.executeQuery(sql, uid);
	}
	/**
	 * 获取每个订单详情
	 */
	@Override
	public List<Map<String, Object>> details(String uid, String serial) {
		String sql="select * from product p inner join tordernumber t on  t.pid=p.pid where uid=? and serial=?";
		return DaoUtil.executeQuery(sql, uid,serial);
	}
	/**
	 * 商品详情购买后 销量加tradeNum
	 */
	@Override
	public int addQuantity( String tradeNum,String pid) {
		String sql="update product set quantity=quantity+? where pid=?";
		return DaoUtil.executeUpdate(sql,tradeNum,pid);
	}

	
	
	

}
