package com.study.qidian;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.Charset;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
* @author quchengguo
* @version 2018年5月3日 下午7:29:35
* 使用HttpClient&Jsoup爬取起点网文章
*/
public class QiDianSpider {

	public static void main(String[] args) throws Exception{
		// 准备资源
		String resource = "https://read.qidian.com/chapter/2QDh2A0mgodcXB4XKBaZpQ2/NG0NAjwV_-76ItTi_ILQ7A2";
		FileWriter file = new FileWriter("E:\\基因叛徒.txt", true);
		BufferedWriter bw = new BufferedWriter(file);
		while(true) {
			// 发起请求
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(resource);
			// 得到响应结果
			CloseableHttpResponse response = httpClient.execute(httpGet);
			String html = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
			Document doc = Jsoup.parse(html);
			
			// 判断是nextUrl是不是书末页
			Element nextUrl = doc.select("#j_chapterNext").get(0);
			if("书末页".equals(nextUrl.text())) {
				System.out.println("已到书末页!!!");
				bw.write("已到书末页!!!");
				bw.flush();
				bw.close();
				file.close();
				break;
			}
			
			// 解析章节内容
			Element chapterName = doc.select(".j_chapterName").get(0);	
			System.out.println(chapterName.text());
			bw.write(chapterName.text() + "\r\n");
			// 获取章节内容, 注意class属性使用[]
			Elements contents = doc.select("div[class=read-content j_readContent] p");
			for (Element element : contents) {
				System.out.println(element.text());
				bw.write(element.text() + "\r\n");
				bw.flush();
			}
			// 获取下一个章节的url
			resource = "http:" + nextUrl.attr("href");
//			System.out.println(resource);
//			System.out.println("*********************************");
		}
	}

}
