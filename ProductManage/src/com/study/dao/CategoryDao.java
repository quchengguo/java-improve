package com.study.dao;

import java.sql.SQLException;
import java.util.List;

import com.study.domain.Category;

/** 
* @author quchengguo
* @version 
*/
public interface CategoryDao {
	/**
	 * 添加分类
	 * @param c
	 * @throws SQLException
	 */
	public void addCategory(Category c) throws SQLException;

	/**
	 * 查询分类
	 */
	public List<Category> findCategory() throws SQLException;
	
	/**
	 * 删除分类
	 * @param cid
	 * @return
	 */
	public void delCategory(Integer cid) throws SQLException;

	/**
	 * 根据cid查询分类
	 * @param cid
	 * @return
	 */
	public Category findById(Integer cid) throws SQLException;

	/**
	 * 更新分类
	 */
	public void updateCategory(Category c) throws SQLException;
	
	
}
