package com.study.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.pojo.User;
import com.study.service.impl.UserService;

/*
* @author quchengguo
* @version 2018年4月21日 下午8:09:17
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisImplTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void implTest() {
		User user = userService.getUserById(1);
		System.out.println(user);
	}
}
