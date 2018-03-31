package com.mvcstudy.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mvcstudy.domain.Student;
import com.mvcstudy.utils.JDBCUtils;

/** 
* @author quchengguo
* @version 2018��3��31�� ����5:17:39 
* ���ݷ��ʲ�
*/
public class StudentDAO {
	/**
	 * ��ȡ����ѧ����Ϣ
	 * @return ѧ����Ϣ
	 * @throws Exception
	 */
	public List<Student> findAll() throws Exception{
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// c3p0ͨ��������ƽ�javabean�����ݿ���ֶζ�Ӧ����
		return qr.query("SELECT * FROM student", new BeanListHandler<Student>(Student.class));
	}
	
}
