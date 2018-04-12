package com.study.domain;

import java.io.Serializable;

/** 
* @author quchengguo
* @version 2018年4月8日 上午9:44:07 
*/
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cid;
	private String cname;
	private String description;
	
	public Category(){
		super();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
