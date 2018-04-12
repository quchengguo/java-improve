package com.study.domain;

import java.io.Serializable;

/** 
* @author quchengguo
* @version 2018年4月10日 上午10:19:43 
*/
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer pid;
	private String pname;
	private float price;
	private String path;
	private String pdescription;
	private Integer categoryid;
	
	public Product() {
		super();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
}
