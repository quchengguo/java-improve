package com.study.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.study.dao.CategoryDao;
import com.study.dao.impl.CategoryImpl;
import com.study.domain.Category;
import com.study.service.CategoryService;

/** 
* @author quchengguo
* @version 2018��4��8�� ����10:40:04 
*/
public class CategoryServiceImpl implements CategoryService {

	@Override
	public void addCategory(Category c) throws SQLException {
		CategoryDao dao = new CategoryImpl();
		dao.addCategory(c);
	}

	@Override
	public List<Category> findCategory() throws SQLException {
		CategoryDao dao = new CategoryImpl();
		return dao.findCategory();
	}

	@Override
	public void delCategory(Integer cid) throws SQLException {
		CategoryDao dao = new CategoryImpl();
		dao.delCategory(cid);
	}

	@Override
	public Category findById(Integer cid) throws Exception{
		CategoryDao dao = new CategoryImpl();
		Category c = dao.findById(cid);
		// 处理找不到时异常
		if(c == null){
			throw new Exception("cid: "+ cid +"对应的分类未找到");
		}
		return c;
	}

	@Override
	public void updateCategory(Category c) throws SQLException{
		CategoryDao dao = new CategoryImpl();
		dao.updateCategory(c);
	}

}
