package com.study.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoubleField;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/*
* @author quchengguo
* @version 2018年5月6日 上午11:21:12
* document -> indexWriter -> directory
* 				  |
* 				analyze
*/
public class LuceneTest {
	
	/**
	 * 索引写入 -》 IndexWriter
	 */
	@Test
	public void createIndex() throws Exception{
		// 数据
		Document doc = new Document();
		Field id = new DoubleField("id", 5.9, Store.YES);
		doc.add(id);
		StringField title = new StringField("title", "世界", Store.YES);
		doc.add(title);
		// 加载ext.dic了之后，"我觉得很垃圾啊"就是一个词语了
		TextField content = new TextField("content", "美好", Store.YES);
		doc.add(content);
		
		Directory dir = FSDirectory.open(new File("E:\\eclipseworkspace01\\lucene-index"));
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
		// 覆盖索引, 默认是APPEND
		iwc.setOpenMode(OpenMode.CREATE);
		// indexWriter 才是核心
		IndexWriter indexWriter = new IndexWriter(dir, iwc);
		indexWriter.addDocument(doc);
		indexWriter.commit();
		// 未close之前dir一直属于锁定状态,其它indexWriter不能操作该dir
		indexWriter.close();
	}
	
	/**
	 * 查询索引：IndexSearcher QueryParser Query TopDocs ScoreDoc
	 * @throws IOException 
	 * @throws ParseException 
	 * 除了content可以搜索其它的不可以搜索？  // 未分词的使用SimpleAnalyzer查询
	 * TODO id怎么查询
	 */
	@Test
	public void searchIndex() throws IOException, ParseException {
		System.out.println(1234);
//		QueryParser parser = new QueryParser("title", new IKAnalyzer());
//		QueryParser parser = new QueryParser("title", new SimpleAnalyzer());
//		Query query = parser.parse("这个世界会好吗");
		QueryParser parser = new QueryParser("id", new IKAnalyzer());
		Query query = parser.parse("5.9");
		baseSearch(query);
	}
	
	/**
	 * 词条查询
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@Test
	public void termSearch() throws IOException, ParseException {
		Query query = new TermQuery(new Term("title", "这个世界会好吗"));
		baseSearch(query);
	}
	
	/**
	 * 模糊查询
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@Test
	public void fuzzyQuery() throws IOException, ParseException {
		// 未创建词条也可以查询
		Query query = new FuzzyQuery(new Term("title", "这个世界会"));
		baseSearch(query);
	}
	
	/**
	 * 数值范围查询
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@Test
	public void numericRangeQuery() throws IOException, ParseException {
		Query query = NumericRangeQuery.newLongRange("id", 2L, 8L, true, true);
		baseSearch(query);
	}
	
	/**
	 * 删除索引
	 * @throws IOException 
	 */
	@Test
	public void deleteIndex() throws IOException {
		IndexWriter indexWriter = new IndexWriter(FSDirectory.open(new File("E:\\eclipseworkspace01\\lucene-index")), new IndexWriterConfig(Version.LATEST, new IKAnalyzer()));
		indexWriter.deleteDocuments(NumericRangeQuery.newLongRange("id", 2L, 6L, true, true));
		indexWriter.commit();
		indexWriter.close();
	}
	
	/**
	 * 修改索引:先删除在添加  success
	 * @throws IOException 
	 */
	@Test
	public void updateIndex() throws IOException {
		// 创建文档对象
		Document doc = new Document();
		doc.add(new LongField("id", 5L, Store.YES));
		doc.add(new StringField("title", "这个世界会好吗", Store.YES));
		doc.add(new TextField("content", "李志:我觉得很好", Store.YES));
		
		// 创建索引写入对象
		IndexWriter indexWriter = new IndexWriter(FSDirectory.open(new File("E:\\eclipseworkspace01\\lucene-index")), new IndexWriterConfig(Version.LATEST, new IKAnalyzer()));
		// 将满足term的document使用doc替换
		indexWriter.updateDocument(new Term("title", "这个世界会好吗"), doc);
		indexWriter.commit();
		indexWriter.close();
	}
	
	
	
	/**
	 * 抽取基本查询方法
	 */
	private void baseSearch(Query query) throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File("E:\\eclipseworkspace01\\lucene-index"));
		IndexReader indexReader = DirectoryReader.open(directory);
		// 创建索引搜索对象，上面两个对象是对indexSearcher的填充
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		
		// 创建查询解析器对象
//		QueryParser parser = new QueryParser("title", new IKAnalyzer());
		 
//		Query query = parser.parse("这个世界会好吗1");
		TopDocs topDocs = indexSearcher.search(query, Integer.MAX_VALUE);
		System.out.println("一共命中: " + topDocs.totalHits + "条");
		
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int doc = scoreDoc.doc;
			System.out.println("编号: " + doc);
			
			Document document = indexReader.document(doc);
			System.out.println("id: " + document.get("id"));
			System.out.println("title: " + document.get("title"));
			System.out.println("content: " + document.get("content"));
		}
		indexReader.close();
	}
	
	
	
	
	
	
	
	
	
}
