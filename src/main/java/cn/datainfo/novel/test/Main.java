package cn.datainfo.novel.test;

import java.util.List;

import cn.datainfo.novel.crawler.CrawlerFactory;
import cn.datainfo.novel.crawler.entity.Book;
import cn.datainfo.novel.crawler.entity.Section;
import cn.datainfo.novel.crawler.intf.Crawler;

/**
 * sample for use novel crawler
 */
public class Main 
{
    public static void main( String[] args )
    {
        // 建立book信息
        Book book = new Book();
        book.setName("娱乐宗师");
        book.setUrl("http://www.miaobige.com/read/7144/");//目录地址
        
        CrawlerFactory cf = CrawlerFactory.getInstance();
        Crawler crawler = cf.getCrawler("miaobige");
        List<Section> sections = crawler.getSectionList(book);
        for (Section section : sections) {
        	//System.out.println("id:"+section.getId()+" name:" + section.getName() + " url:" + section.getUrl());
        	section = crawler.getSectionContent(section);
        	boolean status = crawler.outputSection(book, section, "FILE");
        	if (!status) {
        		System.out.println(section.getName()+" output fault");
        	} else {
        		System.out.println(section.getName()+" output success");
        	}
        }
        
    }
}
