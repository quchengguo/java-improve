package com.study.pojo;

import java.util.List;

/** 
* @author quchengguo
* @version 2018年4月15日 下午7:35:36 
* 包装类
*/
public class QueryVo {
	private User user;
	private List<Integer> ids;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
}
