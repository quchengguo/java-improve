package com.study.spider.cluster;

import org.apache.commons.codec.Charsets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import redis.clients.jedis.Jedis;

/*
* @author quchengguo
* @version 2018年5月5日 下午6:47:46
* 将待爬取的京东商品url存入redis中
*/
public class Master {
	private static Jedis jedis = new Jedis("192.168.60.129", 6379);
	
	public static void main(String[] args) {
		
		try {
			dopaging();
		} catch (Exception e) {
			System.out.println("分页报错：" + e.getMessage());
		}
	}
	
	/**
	 * 分页
	 */
	private static void dopaging() throws Exception{
		int page = 1;
		while (page <= 100) {
			String url = "http://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E6%89%8B%E6%9C%BA&cid2=653&cid3=655&page="
					+ (2 * page - 1);
			System.out.println(url);
			String pagingResult = getHtml(url);
			getSearchResultInfo(pagingResult);
			page++;

		}
	}
	
	/**
	 * 将indexUrl解析为document字符串
	 * @param indexUrl
	 */
	public static String getHtml(String indexUrl) throws Exception{
		HttpGet httpGet = new HttpGet(indexUrl);
		CloseableHttpResponse response = HttpClients.createDefault().execute(httpGet);
		if(200 == response.getStatusLine().getStatusCode()) {
			// 响应成功
			return EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
		}
		return null;
	}
	
	/**
	 * 将每个商品详情页中的商品pid存入redis中
	 * @param indexHtml
	 */
	private static void getSearchResultInfo(String indexHtml) {
		if (indexHtml != null) {
			Document indexDoc = Jsoup.parse(indexHtml);
			// 定位到商品列表
			Elements liList = indexDoc.select("#J_goodsList li[data-pid]");
			for (Element li : liList) {
				// 依次每个商品的详情页，并解析出数据
				try {
//					arrayBlockingQueue.put(li.attr("data-pid"));
					// 之前放在阻塞队列中现在直接放在redis中
					jedis.lpush("bigdata:spider:jd:urls", li.attr("data-pid"));
				} catch (Exception e) {
					System.out.println("商品pid存入redis报错: " + e.getMessage());
				}
			}
		}
	}
	
	

}
