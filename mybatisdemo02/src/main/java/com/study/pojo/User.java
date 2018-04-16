package com.study.pojo;

import java.util.Date;
import java.util.List;

/** 
* @author quchengguo
* @version 2018年4月13日 下午10:20:09 
*/
public class User {
	private Integer id;
	private String username;
	private Date birthday;
	private String address;
	private String sex;
	private List<Orders> orders;
	
	public User(){}
	
	public User(String username, Date birthday, String address, String sex){
		this.username = username;
		this.birthday = birthday;
		this.address = address;
		this.sex = sex;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", address=" + address
				+ ", sex=" + sex + "]";
	}
}
