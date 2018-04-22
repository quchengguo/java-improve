package com.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.impl.UserDao;
import com.study.pojo.User;

/*
* @author quchengguo
* @version 2018年4月21日 下午8:00:35
*/
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	@Override
	public User getUserById(Integer id) {
		return dao.getUserById(id);
	}

}
