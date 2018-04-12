package com.study.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.study.dao.CategoryDao;
import com.study.domain.Category;
import com.study.utils.JDBCUtils;

/** 
* @author quchengguo
* @version 2018��4��8�� ����10:44:03 
*/
public class CategoryImpl implements CategoryDao {

	@Override
	public void addCategory(Category c) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update("INSERT INTO category (cname, description) VALUES (?,?)", c.getCname(), c.getDescription());
	}

	@Override
	public List<Category> findCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Category> cs = qr.query("SELECT * FROM category", new BeanListHandler<Category>(Category.class));
		return cs;
	}

	@Override
	public void delCategory(Integer cid) throws SQLException{
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update("DELETE FROM category WHERE cid = ?", cid);
	}

	@Override
	public Category findById(Integer cid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query("SELECT * FROM category WHERE cid = ?", new BeanHandler<Category>(Category.class), cid);
	}

	@Override
	public void updateCategory(Category c) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update("UPDATE category SET cname=?, description=? WHERE cid=?", c.getCname(), c.getDescription(), c.getCid());
	}
}
