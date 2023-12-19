package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Car;

public interface ICartDao {

	int addCart(Car car);

	List<Map<String, Object>> getUserCart(Object uid);

	List<Map<String, Object>> deleteAll(String uid);

	List<Map<String, Object>> delete(int id, Object uid);

	List<Map<String, Object>> plusNum(String uid, String pid);

	List<Map<String, Object>>reduceNum(String uid, String pid);

	boolean isExistProduct(String uid, String pid);

	int addNum(String uid, String pid);

}
