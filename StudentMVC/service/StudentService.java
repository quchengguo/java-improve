package com.mvcstudy.service;

import java.util.List;

import com.mvcstudy.dao.StudentDAO;
import com.mvcstudy.domain.Student;

/** 
* @author quchengguo
* @version 2018��3��31�� ����5:16:32 
* ҵ���߼���
*/
public class StudentService {
	/*
	 * ��ȡ����ѧ����Ϣ
	 */
	public List<Student> findAll() throws Exception{
		StudentDAO stuDao = new StudentDAO();
		return stuDao.findAll();
	}

}
