package QueryRunnerAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import c3p0_druid.C3P0Utils;


/** 
* @author quchengguo
* @version 2018年3月16日 下午3:16:35 
* QueryRunner实现转账功能
*/
public class AccoutnDemo {

	/**
	 * QueryRunner类下的update
	 * @throws Exception
	 */
	@Test
	public void account() throws Exception{
		// C3P0Utils用到了c3p0包
		// dbUtils下的QueryRunner
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		//		queryRunner.update(C3P0Utils.getConnection(), "INSERT INTO account VALUES(null, 'eee', 10000)");
		// 第一个参数sql，第二个参数sql中的参数
		queryRunner.update("UPDATE account SET money = money + ? WHERE id = ?", -1000, 1);
		queryRunner.update("UPDATE account SET money = money + ? WHERE id = ?", +1000, 2);
	}
	/**
	 * 查询多条记录ResultSetHandler
	 * @throws SQLException 
	 */
	@Test
	public void accountQuery () throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		List<Account> list = queryRunner.query("SELECT * FROM account", new ResultSetHandler<List<Account>>(){

			@Override
			public List<Account> handle(ResultSet rs) throws SQLException {
				List<Account> list = new ArrayList<Account>();
				Account account = new Account();
				while(rs.next()){
					account.setId(rs.getInt("id"));
					account.setName(rs.getString("name"));
					account.setMoney(rs.getDouble("money"));
					list.add(account);
				}
				return list;
			}
			
		});
		for(Account account : list){
			System.out.println(account);
		}
	}
	
	/**
	 * 查询多条记录 ArrayListHandler
	 * @throws SQLException
	 */
	@Test
	public void accountQueryArrayList () throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		List<Object[]> list = queryRunner.query("SELECT * FROM account", new ArrayListHandler());
		for(Object[] objs : list){
			// Arrays.toString 返回指定数组的字符串形式
			System.out.println(Arrays.toString(objs));
		}
		
	}
	/**
	 * 添加事务DbUtils
	 */
	@Test
	public void accoutnTransaction(){
		Connection conn = null;
		QueryRunner queryRunner = null;
		try {
			// 1.获得连接
			conn = C3P0Utils.getConnection();
			// 2.创建关键类
			queryRunner = new QueryRunner();
			// 3.开启事务
			conn.setAutoCommit(false);
			// 4.执行sql
			queryRunner.update(conn, "UPDATE account SET money = money + ? WHERE id = ?", -1000, 1);
			queryRunner.update(conn, "UPDATE account SET money = money + ? WHERE id = ?", +1000, 2);
			// 5.提交事务
			DbUtils.commitAndCloseQuietly(conn);
			System.out.println("转账成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				DbUtils.rollback(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("转账失败");
			e.printStackTrace();
		}
	}
	
	// use resultSetHandler
	@Test
	public void resultSetHandler () throws Exception{
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		Account account = queryRunner.query("SELECT * FROM account", new ResultSetHandler<Account>() {

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account = new Account();
				while(rs.next()){
					account.setId(rs.getInt("id"));
					account.setName(rs.getString("name"));
					account.setMoney(rs.getDouble("money"));
					System.out.println(account);
				}
				return null;
			}
		});
		
	}
	
	
	/**
	 * 使用BeanListHandler查询
	 * @throws SQLException
	 */
	@Test
	public void beanSelectAccount() throws SQLException{
		// 关键类QueryRunner/BeanListHandler
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		List<Account> list = queryRunner.query("SELECT * FROM account", new BeanListHandler<Account>(Account.class));
		for(Account account : list){
			System.out.println(account);
		}
	}

	/**
	 * 使用MapListHandler查询account
	 * @throws SQLException
	 */
	@Test
	public void mapSelectAccount () throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		
		List<Map<String, Object>> mapList = queryRunner.query("SELECT * FROM account", new MapListHandler());
	
		for(Map<String, Object> map : mapList){
			System.out.println(map);
		}
	}

	/**
	 * 使用ColumnListHandler将某列封装到集合中
	 * @throws SQLException
	 */
	@Test
	public void ColumnListHandler () throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		
		List<Object> names = queryRunner.query("SELECT name FROM account", new ColumnListHandler("name"));
	
		for(Object obj : names){
			System.out.println(obj.getClass());
		}
	}

	/**
	 * 使用ScalarHanler将单个值封装
	 * @throws SQLException
	 */
	@Test
	public void scalarHandler () throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		
		Object obj = queryRunner.query("SELECT COUNT(*) FROM account", new ScalarHandler());
		System.out.println(obj);
	}
}
