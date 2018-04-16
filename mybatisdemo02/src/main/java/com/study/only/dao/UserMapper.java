package com.study.only.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.study.pojo.QueryVo;
import com.study.pojo.User;

/** 
* @author quchengguo
* @version 2018年4月14日 上午10:51:48 
*/
public interface UserMapper {
	public User getUserById(Integer id);

	public List<User>getUserByQueryVo(QueryVo vo);

	public int getTotalCount();

	public List<User> getUserByCondition(User user);

	public List<User> getUsersWithIds(QueryVo vo);

	@Select("SELECT * FROM user WHERE username=#{username}")
	public List<User> getUserByName(String userName);

	public List<User> getUsersWithIds2(List<Integer> idList);

	public List<User> getUserWithOrders();
}
