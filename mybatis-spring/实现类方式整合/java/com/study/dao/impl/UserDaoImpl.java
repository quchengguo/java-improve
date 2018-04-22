package com.study.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.study.pojo.User;

/*
* @author quchengguo
* @version 2018年4月21日 下午8:04:55
*/
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	

	@Override
	public User getUserById(Integer id) {
		SqlSession sqlSession = getSqlSession();
		return sqlSession.selectOne("test.getUserById", id);
	}

}
