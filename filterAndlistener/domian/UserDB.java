package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
* @author quchengguo
* @version 2018��4��2�� ����4:27:14 
* user ���ݿ�
*/
public class UserDB{
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("quchengguo", "123"));
		users.add(new User("root", "123"));
		users.add(new User("���ɹ�", "123"));
	}
	
	public static List<User> getUsers(){
		return users;
	}

}
