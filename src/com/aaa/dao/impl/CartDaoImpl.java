package com.aaa.dao.impl;

import java.util.List;
import java.util.Map;
import com.aaa.dao.ICartDao;
import com.aaa.entity.Car;
import com.aaa.util.DaoUtil;
import com.sun.javafx.binding.StringFormatter;

public class CartDaoImpl implements ICartDao {

	@Override
	public int addCart(Car car) {
		String sql = "insert into car values (null , ? , ? , ? , ? , ? ,?)";
		return DaoUtil.executeUpdate(sql, car.getUid() , car.getPid() , car.getPname() , car.getPimage() , car.getPrice() , car.getNum());
	}

	@Override
	public List<Map<String, Object>> getUserCart(Object uid) {
		String sql = "select * from car where uid = ?";
		return DaoUtil.executeQuery(sql, uid);
	}

	@Override
	public List<Map<String, Object>> deleteAll(String uid) {
		String sql = "delete from car where uid = ?";		
		int i = DaoUtil.executeUpdate(sql, uid);
		if(i>0) {
			String sql2 = "select * from car where uid = ?";
			return DaoUtil.executeQuery(sql2, uid);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> delete(int id,Object uid) {
		
		String sql = "delete  from car where oid = ?"; 
		 int i = DaoUtil.executeUpdate(sql, id);
		 
		 if(i>0) {
			 String sql2 = "select * from car where uid = ?"; 
				
			 return DaoUtil.executeQuery(sql2, uid);
		 }
		 return null;
		 
	}

	@Override
	public List<Map<String, Object>> plusNum(String uid, String pid) {
		String sql="update car set num = num +1 where uid = ? and pid = ?  ";
		int i = DaoUtil.executeUpdate(sql, uid,pid);  
		
		if(i>0) {
			String sql2 = "select * from car where uid = ?";
			return DaoUtil.executeQuery(sql2, uid);
		}
		return null;
		
	}

	@Override
	public List<Map<String, Object>> reduceNum(String uid, String pid) {
		String sql="update car set num = num - 1 where uid = ? and pid = ? and num>1";
		int i = DaoUtil.executeUpdate(sql, uid,pid);
		
		if(i>0) {
			String sql2 = "select * from car where uid = ?";
			return DaoUtil.executeQuery(sql2, uid);
		}
		
		return null;
	}

	@Override
	public boolean isExistProduct(String uid, String pid) {
		String sql="select * from car where uid=? and pid=?";
		 List<Map<String, Object>> list = DaoUtil.executeQuery(sql,uid,pid);
		 if(list.size()>0) {
			 return true;
		 }
		 return false;
	}

	@Override
	public int addNum(String uid, String pid) {
		String sql="update car set num = num +1 where uid = ? and pid = ?  ";
		return DaoUtil.executeUpdate(sql, uid,pid);
	}
}
