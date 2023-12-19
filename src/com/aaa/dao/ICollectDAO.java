package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Collect;

public interface ICollectDAO {

	int productCollect(Collect collect);

	List<Map<String, Object>> getUserCollect(Object uid);

	int deleteOne(String pid, String uid);

	boolean isExist(int pid, String uid);

	int addProductNum(String pid);

	int reduceProductNum(String pid);
	
}
