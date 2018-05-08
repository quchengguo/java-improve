package com.study.pojo;

import org.apache.solr.client.solrj.beans.Field;

/*
* @author quchengguo
* @version 2018年5月8日 下午7:53:32
* @Field("name") name必须和schema.xml中的<field>标签中的name一致
*/
public class Item {
	@Field("id")
	private String id;
	@Field("name")
	private String name;
	@Field("title")
	private String title;
	@Field("text")
	private String text;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", title=" + title + ", text=" + text + "]";
	}
}
