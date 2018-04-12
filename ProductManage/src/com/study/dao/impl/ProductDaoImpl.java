package com.study.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.study.dao.ProductDao;
import com.study.domain.Product;
import com.study.utils.JDBCUtils;

/** 
* @author quchengguo
* @version 2018年4月10日 下午12:35:43 
*/
public class ProductDaoImpl implements ProductDao {

	@Override
	public void addProduct(Product p) throws Exception {
		QueryRunner qr  = new QueryRunner(JDBCUtils.getDataSource());
		// 你经常在SQL这里犯错误，你死不死~
		qr.update("INSERT INTO product (pname, price, path, pdescription, categoryid) VALUES (?, ?, ?, ?, ?)",
				p.getPname(), p.getPrice(), p.getPath(), p.getPdescription(), p.getCategoryid());
	}

	@Override
	public List<Product> findProduct() throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query("SELECT * FROM product", new BeanListHandler<Product>(Product.class));
	}

	@Override
	public List<Product> findProductByCategoryid(Integer categoryid) throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query("SELECT * FROM product WHERE categoryid = ?", new BeanListHandler<Product>(Product.class), categoryid);
	}

	@Override
	public void delProduct(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update("DELETE FROM product WHERE pid = ?", pid);
	}

	@Override
	public Product findProductById(Integer pid) throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query("SELECT * FROM product WHERE pid = ?", new BeanHandler<Product>(Product.class), pid);
	}

	@Override
	public void updateProductById(Product product) throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update("UPDATE product SET pname=?, price=?, pdescription=?, categoryid=? WHERE pid=?",
				product.getPname(), product.getPrice(), product.getPdescription(), product.getCategoryid(), product.getPid());
	}

}
