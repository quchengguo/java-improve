package com.study.service;

import java.sql.SQLException;
import java.util.List;

import com.study.domain.Category;

/** 
* @author quchengguo
* @version 2018��4��8�� ����10:37:39 
*/
public interface CategoryService {
	/**
	 * 添加分类
	 * @param c
	 * @throws SQLException
	 */
	public void addCategory(Category c) throws SQLException;

	/**
	 * 查询分类
	 * @return
	 */
	public List<Category> findCategory() throws SQLException;
	
	/**
	 * 删除分类
	 * @param cid
	 */
	public void delCategory(Integer cid) throws SQLException;

	/**
	 * 通过id查询分类
	 * @param cid
	 * @return
	 */
	public Category findById(Integer cid) throws Exception;
	
	/**
	 * 修改分类
	 * @param c
	 */
	public void updateCategory(Category c) throws Exception;
}
