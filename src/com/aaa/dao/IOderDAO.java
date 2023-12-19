package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Order;

public interface IOderDAO {

	int addOrder(Order order);

	int addOrders(Order order);

	List<Map<String,Object>> getMyOrders(String uid);

	List<Map<String,Object>> details(String uid, String serial);

	int addQuantity(String tradeNum, String pid);
	
}
