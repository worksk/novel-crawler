package cn.datainfo.novel.crawler;

import cn.datainfo.novel.crawler.intf.Crawler;

public class CrawlerFactory {
	
	private static CrawlerFactory instance;
	
	private CrawlerFactory(){}
	
	public static CrawlerFactory getInstance() {
		if (instance == null) {
			instance = new CrawlerFactory();
		}
		
		return instance;
	}
	
	public Crawler getCrawler(String crawlerType) {
		
		if (crawlerType == null) {
			return null;
		}
		if (crawlerType.equals("83k")) {
			return new Host83KCrawler();
		}
		if (crawlerType.equals("miaobige")) {
			return new MiaobigeCrawler();
		}
		
		
		return null;
	}

}
