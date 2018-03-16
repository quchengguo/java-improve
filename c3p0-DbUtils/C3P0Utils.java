package c3p0_druid;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
* @author quchengguo
* @version 2018��3��16�� ����1:48:25 
* C3P0������
*/
public class C3P0Utils {
	
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	// ��ȡ����
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	// ��ȡDataSource
	public static DataSource getComboPooledDataSource(){
		return  dataSource;
	}
}
