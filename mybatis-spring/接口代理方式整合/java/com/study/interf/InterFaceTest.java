package com.study.interf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.pojo.User;

/*
* @author quchengguo
* @version 2018年4月22日 上午9:41:31
* 测试spring与mybatis整合(接口代理方式)
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class InterFaceTest {
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void interfTest() {
		User user = mapper.getUserById(1);
		System.out.println(user);
	}
}
