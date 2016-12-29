package cn.datainfo.novel.crawler.intf;

import java.util.List;

import cn.datainfo.novel.crawler.entity.Book;
import cn.datainfo.novel.crawler.entity.Section;

public interface Crawler {
	
	/**
	 * 获取章节列表
	 * @param book 填充name和url
	 * @return
	 */
	List<Section> getSectionList(Book book);
	
	/**
	 * 获取章节内容
	 * @param section 章节对象，填充name和url
	 * @return
	 */
	Section getSectionContent(Section section);

	/**
	 * 存储章节内容
	 * @param book 
	 * @param section
	 * @param type ：FILE，MYSQL
	 */
	boolean outputSection(Book book, Section section, String type);
	
}
