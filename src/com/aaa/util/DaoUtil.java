package com.aaa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DaoUtil {

	private static DataSource source = null;
	
	static {
		try {
			Properties p = new Properties();
			
			p.load(DaoUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
			
			source = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection conn = source.getConnection();
		return conn;
	}
	public static int executeUpdate(String sql , Object... data) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DaoUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < data.length; i++) {
				ps.setObject(i+1, data[i]);
			}
			int i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}
		return 0;
	}
	public static List<Map<String , Object>> executeQuery(String sql , Object... data){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < data.length; i++) {
				ps.setObject(i+1, data[i]);
			}
			List<Map<String , Object>> list = new ArrayList<>();
			set = ps.executeQuery();
			int count = set.getMetaData().getColumnCount();
			while(set.next()) {
				Map<String,Object> map = new HashMap<>();
				for (int i = 1; i <= count; i++) {
					String name = set.getMetaData().getColumnLabel(i);
					Object values = set.getObject(i);
					map.put(name, values);
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(set, ps, conn);
		}
		return null;
	}
	private static void close(ResultSet set , PreparedStatement ps , Connection conn) {
		try {
			if(set != null) set.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ps != null) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
