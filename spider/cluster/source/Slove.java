package com.study.spider.cluster;

import java.util.List;

import org.apache.commons.codec.Charsets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.spider.jd.Product;
import com.study.spider.jd.ProductDao;

import redis.clients.jedis.Jedis;

/*
* @author quchengguo
* @version 2018年5月5日 下午7:02:20
* 作为redis的消费者,从redis中取url,解析商品信息之后存入数据库
* node01 192.168.60.129
*/
public class Slove {
	
	private final static ProductDao productDao = new ProductDao();
	private final static Jedis jedis = new Jedis("192.168.60.129", 6379);
	
	public static void main(String[] args) {
		while(true) {
			List<String> result = jedis.blpop(0, "bigdata:spider:jd:urls");
			String pId = result.get(1);
			// 根据url获取数据，处理商品信息
			try {
				Thread.sleep(2000); 
				parseProductDetail(pId);
			} catch (Exception e) {
				System.out.println("pid处理失败：" + pId);
				e.printStackTrace();
				// 再将PID存放到队列中，等待下次爬取。
				jedis.lpush("bigdata:spider:jd:urls", pId);
			}
		}
	}
	
	/**
	 * 解析每个手机商品的html
	 * @param productUrl
	 */
	private static void parseProductDetail(String productId) throws Exception{
		Product product = new Product();
		String productUrl = "http://item.jd.com/" + productId + ".html";
		String productHtml = getHtml(productUrl);
		Document productDoc = Jsoup.parse(productHtml);
		// 将productDoc中的内容解析出来放在product实体中
		Element title = productDoc.select("div[class=sku-name]").get(0);
		Element brand = productDoc.select("#parameter-brand li").get(0);
		Elements details = productDoc.select("ul[class=parameter2 p-parameter-list] li");
		for (Element productAttribute : details) {
			if(productAttribute.text().contains("商品名称")) {
				product.setName(productAttribute.text().substring(5));
			}
		}
		
		product.setId(productId);
		product.setTitle(title.text());
		product.setBrand(brand.text().substring(3));
		product.setUrl(productUrl);
		
		// 获取价格，价格属于ajax请求加载出来的，首先拼接url，发送请求之后解析回来的数据
		String priceUrl = "http://p.3.cn/prices/mgets?&type=1&area=1_72_2799_0&pdtk=&pduid=2098855974&pdpin=&pin=null&pdbp=0&ext=11000000&source=item-pc&skuIds=J_" + productId;
		String priceResult = getHtml(priceUrl);
		System.out.println("请求url: " + priceUrl);
		System.out.println("返回结果: " + priceResult);
		JSONArray priceJsonArr = JSONObject.parseArray(priceResult);
		product.setPrice(priceJsonArr.getJSONObject(0).getString("op"));
		productDao.saveProduct(product);
//		System.out.println(product);
		
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

}
