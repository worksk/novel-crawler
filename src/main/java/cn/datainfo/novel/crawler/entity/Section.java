package cn.datainfo.novel.crawler.entity;

public class Section {
	
	// 章节id
	private String id;
	// 章节名字
	private String name;
	// 章节的url
	private String url;
	// 章节内容
	private String centent;
	
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
	public String getCentent() {
		return centent;
	}
	public void setCentent(String centent) {
		this.centent = centent;
	}
	
}
