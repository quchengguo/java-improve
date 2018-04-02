package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
* @author quchengguo
* @version 2018年4月2日 下午4:27:14 
* user 数据库
*/
public class UserDB{
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("quchengguo", "123"));
		users.add(new User("root", "123"));
		users.add(new User("屈成国", "123"));
	}
	
	public static List<User> getUsers(){
		return users;
	}

}
