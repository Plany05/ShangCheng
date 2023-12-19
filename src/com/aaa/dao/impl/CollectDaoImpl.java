package com.aaa.dao.impl;

import java.util.List;
import java.util.Map;

import com.aaa.dao.ICollectDAO;
import com.aaa.entity.Collect;
import com.aaa.util.DaoUtil;

public class CollectDaoImpl implements ICollectDAO{
	/**
	 * ����ղؼ���Ϣ(�û�ID����ƷID)
	 */
	@Override
	public int productCollect(Collect collect) {
		String sql="insert into collect values (null,?,?);";
		return DaoUtil.executeUpdate(sql, collect.getPid(),collect.getUid());
	}
	/**
	 * �����û���id��ȡ�ղؼ���Ϣ
	 */
	@Override
	public List<Map<String, Object>> getUserCollect(Object uid) {
		String sql="select *from product p inner join collect c on p.pid=c.pid where uid=?";
		return DaoUtil.executeQuery(sql, uid);
	}
	/**
	 * ����pid �� uid ɾ���ղؼ���Ϣ
	 */
	@Override
	public int deleteOne(String pid,String uid) {
		String sql="delete from collect where pid=? and uid=?";
		return DaoUtil.executeUpdate(sql,pid,uid);
	}
	/**
	 * �ж��û��Ƿ��Ѿ��ղع�
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
	 * ����ղغ�product���е�collect��1
	 */
	@Override
	public int addProductNum(String pid) {
		String sql="update product set collect = collect +1 where pid = ?";
		return DaoUtil.executeUpdate(sql, pid);
	}
	/**
	 * ����ղؼе�ɾ����  product���е�collect��ֵ��1
	 */
	@Override
	public int reduceProductNum(String pid) {
		String sql="update product set collect = collect -1 where pid = ?";
		return DaoUtil.executeUpdate(sql, pid);
	}

	
}
