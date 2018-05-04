package com.study.spider.jd;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

/*
* @author quchengguo
* @version 2018年5月4日 下午7:44:26
* 爬取京东手机页面
* 1.解析首页，得到商品列表
* 2.解析每页信息，得商品详情
* 3.保存到数据库中
* 4.分页
* 5.使用线程池优化项目 (不访问主页，直接从第一页开始)
*/
public class JDSpider {
	private final static ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(1000);
	private final static ExecutorService threadPool = Executors.newFixedThreadPool(10);
	private final static ProductDao productDao = new ProductDao();
	
	public static void main(String[] args){
		// 手机首页
		String resource = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=69cc68c894f640d688ef4e032fca5a1a";
//		try {
////			String html = getHtml(resource);
//			parseHtml(resource);
//		} catch(Exception e) {
//			System.out.println("解析手机首页报错: " + e.getMessage());
//		}
		// 使用线程技术消费队列的数据
		
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println("当前线程池中有" + arrayBlockingQueue.size() + "等待爬取!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// 使用十个线程消费队列
		for (int i = 0; i <= 9; i++) {
			// 使用线程技术消费队列的数据-----------------专门用来消费数据
			threadPool.execute(new Runnable() {
				public void run() {
					while (true) {
						try {
							String pid = arrayBlockingQueue.take();
							parseProductDetail(pid);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			});
		}
		
		try {
//			parseHtml(resource);
			dopaging();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 分页
	 */
	private static void dopaging() throws Exception{
		int page = 1;
		while (page <= 100) {
			String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E6%89%8B%E6%9C%BA&cid2=653&cid3=655&page="
					+ (2 * page - 1);
			System.out.println(url);
			System.out.println("*****************************8");
			String pagingResult = getHtml(url);
			getSearchResultInfo(pagingResult);
			page++;

		}
	}


	/**
	 * 解析手机商品首页html
	 * @param html
	 */
//	private static void parseHtml(String resource) throws Exception{
//		String indexHtml = getHtml(resource);
//		Document indexDoc = Jsoup.parse(indexHtml);
//		// 定位到商品列表
//		Elements goodList = indexDoc.select("#J_goodsList li[data-pid]");
//		for (Element product : goodList) {
//			try {
//				parseProductDetail(product.attr("data-pid"));
//			}catch(Exception e) {
//				System.out.println("解析商品失败: " + e.getMessage());
//			}
//		}
//		
//	}
	
	/**
	 * 解析每个手机商品的html
	 * @param productUrl
	 */
	private static void parseProductDetail(String productId) throws Exception{
		Product product = new Product();
		String productUrl = "https://item.jd.com/" + productId + ".html";
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
		String priceUrl = "https://p.3.cn/prices/mgets?skuIds=J_" + productId;
		String priceResult = getHtml(priceUrl);
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
	
	
	/**
	 * 将每个商品详情页中的商品pid存入队列中
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
					arrayBlockingQueue.put(li.attr("data-pid"));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
