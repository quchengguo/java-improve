package com.study.spider.jd;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ProductDao extends JdbcTemplate {

	public ProductDao() {
		// c3p0连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// 1.url
		// 2.driver
		// 3.username&password
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spider?characterEncoding=utf-8&useSSL=true");
		setDataSource(dataSource);
	}

	public void saveProduct(Product product) {
		String sql = "INSERT INTO `spider`.`jd_product`(`id`, `url`, `name`, `price`, `brand`, `title`) VALUES (?, ?, ?, ?, ?, ?);";
		update(sql, product.getId(), product.getUrl(), product.getName(), product.getPrice(), product.getBrand(), product.getTitle());
	}

}
