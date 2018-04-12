package com.study.service.impl;

import java.util.List;

import com.study.dao.ProductDao;
import com.study.dao.impl.ProductDaoImpl;
import com.study.domain.Product;
import com.study.service.ProductService;

/** 
* @author quchengguo
* @version 2018年4月10日 下午12:33:28 
*/
public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product p) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		dao.addProduct(p);
	}

	@Override
	public List<Product> findProduct() throws Exception{
		ProductDao dao = new ProductDaoImpl();
		return dao.findProduct();
	}

	@Override
	public List<Product> findProductByCategory(Integer categoryid) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		
		return dao.findProductByCategoryid(categoryid);
	}

	@Override
	public void delProduct(String pid) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		dao.delProduct(pid);
	}

	@Override
	public void delMultiProduct(String pids) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		String[] pidArr = pids.split(",");
		for(String pid : pidArr){
			dao.delProduct(pid);
		}
	}

	@Override
	public Product findProductById(Integer pid) throws Exception{
		ProductDao dao = new ProductDaoImpl();
		Product product = dao.findProductById(pid);
		if(product == null){
			throw new Exception("product 为空");
		}
		return product;
	}

	@Override
	public void updateProductById(Product product) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		dao.updateProductById(product);
	}

}
