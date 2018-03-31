package com.mvcstudy.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mvcstudy.domain.Student;
import com.mvcstudy.utils.JDBCUtils;

/** 
* @author quchengguo
* @version 2018年3月31日 下午5:17:39 
* 数据访问层
*/
public class StudentDAO {
	/**
	 * 获取所有学生信息
	 * @return 学生信息
	 * @throws Exception
	 */
	public List<Student> findAll() throws Exception{
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// c3p0通过反射机制将javabean和数据库表字段对应起来
		return qr.query("SELECT * FROM student", new BeanListHandler<Student>(Student.class));
	}
	
}
