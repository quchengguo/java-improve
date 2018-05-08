package com.study.solr;
/*
* @author quchengguo
* @version 2018年5月8日 下午7:40:38
*/

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import com.study.pojo.Item;

public class SolrJTest {
	
	/**
	 * 添加或者修改索引库
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void createTest() throws SolrServerException, IOException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "4");
		document.addField("title", "php");
		document.addField("text", "世界上最好的语言");
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}
	
	/**
	 * 添加bean
	 * @throws SolrServerException 
	 * @throws IOException 
	 */
	@Test
	public void createByBeadTest() throws IOException, SolrServerException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		
		Item item = new Item();
//		item.setId("2");
//		item.setName("c语言");
//		item.setTitle("丹尼斯");
//		item.setText("一切操作系统");
//		item.setId("6");
//		item.setName("java");
//		item.setTitle("javaEE");
//		item.setText("javaWEB");
//		item.setId("4");
//		item.setName("PHP");
//		item.setTitle("超文本预处理器");
//		item.setText("最好的语言");
		item.setId("7");
		item.setName("python1");
		item.setTitle("脚本1");
		item.setText("人工智能1");
		solrServer.addBean(item);
		solrServer.commit();
	}
	
	/**
	 * 删除索引库
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void deleteTest() throws SolrServerException, IOException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		
//		solrServer.deleteById("change.me");
		solrServer.deleteByQuery("title:java");
		
		solrServer.commit();
	}
	
	/**
	 * 查询索引库数据
	 * @throws SolrServerException 
	 */
	@Test
	public void queryTest() throws SolrServerException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		
		QueryResponse response = solrServer.query(new SolrQuery("*:*"));
		SolrDocumentList results = response.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.println("id: " + solrDocument.get("id"));
			System.out.println("name: " + solrDocument.get("name"));
			System.out.println("title: " + solrDocument.get("title"));
			System.out.println("text: " + solrDocument.get("text"));
		}
	}
	
	/**
	 * 以JavaBean查询结果返回
	 * @throws SolrServerException 
	 */
	@Test
	public void queryBeanTest() throws SolrServerException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		
		QueryResponse response = solrServer.query(new SolrQuery("*:*"));
		List<Item> items = response.getBeans(Item.class);
		System.out.println("一共查询到" + items.size() + "条数据");
		for (Item item : items) {
			System.out.println(item);
		}
	}
	
	/**
	 * solrQuery对象的特殊查询
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void solrQueryTest() throws SolrServerException, IOException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		// boolean查询 or and not 
//		QueryResponse response = solrServer.query(new SolrQuery("name:python1 OR name:python"));
		// 相似度查询~表示模糊查询，默认编辑距离为2 pytho~2
		QueryResponse response = solrServer.query(new SolrQuery("id:[2 TO 5]"));
		List<Item> items = response.getBeans(Item.class);
		for (Item item : items) {
			System.out.println(item);
		}
	}
	
	/**
	 * 排序查询 & 分页
	 * @throws SolrServerException 
	 */
	@Test
	public void querySortTest() throws SolrServerException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		int pageNum = 2;
		int pageSize = 3;
		SolrQuery query = new SolrQuery("title:*");
		query.setSort("id", ORDER.desc);
		query.setStart((pageNum-1)*pageSize);
		query.setRows(pageSize);
		QueryResponse response = solrServer.query(query);
		List<Item> items = response.getBeans(Item.class);
		for (Item item : items) {
			System.out.println(item);
		}
		
	}
	
	/**
	 * 高亮显示
	 * @throws SolrServerException 
	 */
	@Test
	public void  highLightingQueryTest() throws SolrServerException {
		HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/core1");
		SolrQuery query = new SolrQuery("title:javaEE");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		query.addHighlightField("title");
		QueryResponse response = solrServer.query(query);
		//  外层的Map，key：id，value：id以外的其他高亮字段，可能有多个，也是一个Map
		// 内层的Map，key：高亮字段的名称，value：字段的内容，集合
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
//		SolrDocumentList results = response.getResults();
//		for (SolrDocument solrDocument : results) {
//			System.out.println(highlighting.get(solrDocument.get("title")));
//		}
		List<Item> items = response.getBeans(Item.class);
		for (Item item : items) {
			System.out.println(highlighting.get(item.getId()).get("title").get(0));
		}
		
	}
	
}
