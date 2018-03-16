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
* @version 2018��3��16�� ����3:16:35 
* QueryRunnerʵ��ת�˹���
*/
public class AccoutnDemo {

	/**
	 * QueryRunner���µ�update
	 * @throws Exception
	 */
	@Test
	public void account() throws Exception{
		// C3P0Utils�õ���c3p0��
		// dbUtils�µ�QueryRunner
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		//		queryRunner.update(C3P0Utils.getConnection(), "INSERT INTO account VALUES(null, 'eee', 10000)");
		// ��һ������sql���ڶ�������sql�еĲ���
		queryRunner.update("UPDATE account SET money = money + ? WHERE id = ?", -1000, 1);
		queryRunner.update("UPDATE account SET money = money + ? WHERE id = ?", +1000, 2);
	}
	/**
	 * ��ѯ������¼ResultSetHandler
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
	 * ��ѯ������¼ ArrayListHandler
	 * @throws SQLException
	 */
	@Test
	public void accountQueryArrayList () throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		List<Object[]> list = queryRunner.query("SELECT * FROM account", new ArrayListHandler());
		for(Object[] objs : list){
			// Arrays.toString ����ָ��������ַ�����ʽ
			System.out.println(Arrays.toString(objs));
		}
		
	}
	/**
	 * �������DbUtils
	 */
	@Test
	public void accoutnTransaction(){
		Connection conn = null;
		QueryRunner queryRunner = null;
		try {
			// 1.�������
			conn = C3P0Utils.getConnection();
			// 2.�����ؼ���
			queryRunner = new QueryRunner();
			// 3.��������
			conn.setAutoCommit(false);
			// 4.ִ��sql
			queryRunner.update(conn, "UPDATE account SET money = money + ? WHERE id = ?", -1000, 1);
			queryRunner.update(conn, "UPDATE account SET money = money + ? WHERE id = ?", +1000, 2);
			// 5.�ύ����
			DbUtils.commitAndCloseQuietly(conn);
			System.out.println("ת�˳ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				DbUtils.rollback(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("ת��ʧ��");
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
	 * ʹ��BeanListHandler��ѯ
	 * @throws SQLException
	 */
	@Test
	public void beanSelectAccount() throws SQLException{
		// �ؼ���QueryRunner/BeanListHandler
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		List<Account> list = queryRunner.query("SELECT * FROM account", new BeanListHandler<Account>(Account.class));
		for(Account account : list){
			System.out.println(account);
		}
	}

	/**
	 * ʹ��MapListHandler��ѯaccount
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
	 * ʹ��ColumnListHandler��ĳ�з�װ��������
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
	 * ʹ��ScalarHanler������ֵ��װ
	 * @throws SQLException
	 */
	@Test
	public void scalarHandler () throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getComboPooledDataSource());
		
		Object obj = queryRunner.query("SELECT COUNT(*) FROM account", new ScalarHandler());
		System.out.println(obj);
	}
}
