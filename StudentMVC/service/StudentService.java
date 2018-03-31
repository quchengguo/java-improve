package com.mvcstudy.service;

import java.util.List;

import com.mvcstudy.dao.StudentDAO;
import com.mvcstudy.domain.Student;

/** 
* @author quchengguo
* @version 2018年3月31日 下午5:16:32 
* 业务逻辑层
*/
public class StudentService {
	/*
	 * 获取所有学生信息
	 */
	public List<Student> findAll() throws Exception{
		StudentDAO stuDao = new StudentDAO();
		return stuDao.findAll();
	}

}
