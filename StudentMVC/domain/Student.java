package com.mvcstudy.domain;

import java.io.Serializable;

/** 
* @author quchengguo
* @version 2018年3月31日 下午5:11:24 
* 学生javaBean，属性名和学生表字段名必须一一对应
*/
public class Student implements Serializable{
	private String sname;
	private Integer age;
	private String gender;
	
	public Student() {}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
