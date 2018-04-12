package com.study.service;

import java.util.List;

import com.study.domain.Product;

/** 
* @author quchengguo
* @version 2018年4月10日 下午12:31:53 
*/
public interface ProductService {
	public void addProduct(Product p) throws Exception;

	public List<Product> findProduct() throws Exception;

	public List<Product> findProductByCategory(Integer categoryid) throws Exception;

	public void delProduct(String pid) throws Exception;

	public void delMultiProduct(String pids) throws Exception;

	public Product findProductById(Integer pid) throws Exception;

	public void updateProductById(Product product) throws Exception;
	
}
