package com.study.only.dao;

import java.util.List;

import com.study.pojo.Orders;

/** 
* @author quchengguo
* @version 2018年4月15日 下午8:06:15 
*/
public interface OrdersMapper {

	public List<Orders> getOrdersList();

	public List<Orders> getOrdersByNotNullNote();

	public List<Orders> getUserByOrders();

}
