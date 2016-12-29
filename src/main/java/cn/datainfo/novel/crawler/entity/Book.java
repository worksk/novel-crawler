package cn.datainfo.novel.crawler.entity;

import java.util.List;

public class Book {
	
	// 书的id
	private String id;
	// 书的名字
	private String name;
	// 书的地址
	private String url;
	// 章节列表
	private List<Section> sections;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	
}
