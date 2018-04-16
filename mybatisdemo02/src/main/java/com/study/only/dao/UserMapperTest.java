package com.study.only.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.study.pojo.Orders;
import com.study.pojo.QueryVo;
import com.study.pojo.User;

/** 
* @author quchengguo
* @version 2018年4月14日 上午10:56:45 
*/
public class UserMapperTest {
	private SqlSession sqlSession;
	
	@Before
	public void init() throws IOException{
		// 1.创建builder
		// 2.使用builder导入核心配置文件
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		// 3.获取sqlsession
		sqlSession = factory.openSession();
	}

	
	@Test
	public void getUserById(){
		// 接口代理方式
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user.toString());
		// sqlSession用完即关
		sqlSession.close();
	}
	
	/**
	 * QueryVo测试
	 */
	@Test
	public void  queryVoUser(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setAddress("河南");
		vo.setUser(user);
		List<User> users = mapper.getUserByQueryVo(vo);
		for (User user2 : users) {
			System.out.println(user2);
		}
		
	}
	
	/**
	 * SELECT COUNT(*) FROM USER;
	 */
	@Test
	public void getTotalCount(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int count = mapper.getTotalCount();
		System.out.println(count);
	}
	
	/**
	 * 查询所有的订单
	 */
	@Test
	public void getOrdersList(){
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> orders = mapper.getOrdersList();
		for (Orders orders2 : orders) {
			System.out.println(orders2);
		}
	}
	
	/**
	 * 查询note不为空的订单  ？？？
	 */
	@Test
	public void getOrdersAndNoteNotNull(){
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		/*User user = new User();
		user.setId(1);
		User user2 = new User();
		user2.setId(2);*/
		List<Orders> orders = mapper.getOrdersByNotNullNote();
		for (Orders orders2 : orders) {
			System.out.println(orders2);
		}
	}
	
	/**
	 * <where> <if>
	 */
	@Test
	public void getUserByCondition(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
//		user.setId(22);
		user.setAddress("河南");
		List<User> userList = mapper.getUserByCondition(user);
		for (User user2 : userList) {
			System.out.println(user2);
		}
	}
	
	/**
	 * <foreach>
	 */
	@Test
	public void getUsersWithIds(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(10);
		ids.add(22);
		vo.setIds(ids);
		List<User> userList = mapper.getUsersWithIds(vo);
		for (User user : userList) {
			System.out.println(user);
		}
		
	}
	
	/**
	 * <foreach>
	 */
	@Test
	public void getUsersWithIds2(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(10);
		idList.add(22);
		List<User> userList = mapper.getUsersWithIds2(idList);
		for (User user : userList) {
			System.out.println(user);
		}
		
	}
	
	/**
	 * 一对一  
	 *  orders(1) - user(1)
	 */
	@Test
	public void getUserByOrders(){
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> ordersList = mapper.getUserByOrders();
		for (Orders orders : ordersList) {
			System.out.println(orders.getUser());
		}
	}
	
	/**
	 * 一对多	user(1) - orders(n) 
	 * 一个用户对应多个订单，在一方创建多方的list
	 */
	@Test
	public void getUserWithOrders(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.getUserWithOrders();
		for (User user : userList) {
			for(Orders order : user.getOrders()){
				System.out.println(order);
			}
		}
	}
	
	/**
	 * @select 测试
	 * 不需要写xml
	 */
	@Test
	public void getUserByName(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.getUserByName("王五");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@After
	public void destory(){
		sqlSession.close();
	}
}
