package c3p0_druid;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
* @author quchengguo
* @version 2018年3月16日 下午1:48:25 
* C3P0工具类
*/
public class C3P0Utils {
	
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	// 获取连接
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	// 获取DataSource
	public static DataSource getComboPooledDataSource(){
		return  dataSource;
	}
}
