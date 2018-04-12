package com.study.dao;

import java.util.List;

import com.study.domain.Product;

/** 
* @author quchengguo
* @version 2018年4月10日 下午12:35:07 
*/
public interface ProductDao {
	public void addProduct(Product p) throws Exception;

	public List<Product> findProduct() throws Exception;

	public List<Product> findProductByCategoryid(Integer categoryid) throws Exception;

	public void delProduct(String pid) throws Exception;

	public Product findProductById(Integer pid) throws Exception;

	public void updateProductById(Product product) throws Exception;
}
