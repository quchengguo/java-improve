package com.mvcstudy.utils;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// 创建一个连接池：但是这个连接池只需要创建一次即可。
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * 获得连接的方法
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 获得数据源:
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
