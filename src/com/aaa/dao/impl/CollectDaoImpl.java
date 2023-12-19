package com.aaa.dao.impl;

import java.util.List;
import java.util.Map;

import com.aaa.dao.ICollectDAO;
import com.aaa.entity.Collect;
import com.aaa.util.DaoUtil;

public class CollectDaoImpl implements ICollectDAO{
	/**
	 * 添加收藏夹信息(用户ID和商品ID)
	 */
	@Override
	public int productCollect(Collect collect) {
		String sql="insert into collect values (null,?,?);";
		return DaoUtil.executeUpdate(sql, collect.getPid(),collect.getUid());
	}
	/**
	 * 根据用户的id获取收藏夹信息
	 */
	@Override
	public List<Map<String, Object>> getUserCollect(Object uid) {
		String sql="select *from product p inner join collect c on p.pid=c.pid where uid=?";
		return DaoUtil.executeQuery(sql, uid);
	}
	/**
	 * 根据pid 和 uid 删除收藏夹信息
	 */
	@Override
	public int deleteOne(String pid,String uid) {
		String sql="delete from collect where pid=? and uid=?";
		return DaoUtil.executeUpdate(sql,pid,uid);
	}
	/**
	 * 判断用户是否已经收藏过
	 */
	@Override
	public boolean isExist(int pid, String uid) {
		String sql="select * from collect where pid=? and uid=?";
		List<Map<String, Object>> list = DaoUtil.executeQuery(sql,pid,uid);
		if(list.size()>0) {
			return false;
		}
		return true;
		
	}
	/**
	 * 点击收藏后product表中的collect加1
	 */
	@Override
	public int addProductNum(String pid) {
		String sql="update product set collect = collect +1 where pid = ?";
		return DaoUtil.executeUpdate(sql, pid);
	}
	/**
	 * 点击收藏夹的删除后  product表中的collect的值减1
	 */
	@Override
	public int reduceProductNum(String pid) {
		String sql="update product set collect = collect -1 where pid = ?";
		return DaoUtil.executeUpdate(sql, pid);
	}

	
}
