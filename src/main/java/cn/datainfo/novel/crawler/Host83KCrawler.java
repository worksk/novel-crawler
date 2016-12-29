package cn.datainfo.novel.crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.datainfo.novel.crawler.entity.Book;
import cn.datainfo.novel.crawler.entity.Section;
import cn.datainfo.novel.crawler.intf.Crawler;

public class Host83KCrawler implements Crawler {
	static final String NEWLINE = System.getProperty("line.separator");
	private FileWriter writer = null;
	private String filePaht = "./";

	public List<Section> getSectionList(Book book) {
		List<Section> sections = new ArrayList<Section>();
		int count = 0;
		try {
			Document doc = Jsoup.connect(book.getUrl())
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
					.timeout(10000).get();

			Element table = doc.getElementsByTag("table").get(0);
			Elements trs = table.getElementsByTag("tr");
			for (Element td : trs) {
				for (Element aTag : td.getElementsByTag("a")) {
					Section st = new Section();
					String url = book.getUrl().replace("index.html", "");
					st.setUrl(url + aTag.attr("href"));
					if (aTag.text().equals("分卷阅读")) {
						continue;
					}
					st.setName(aTag.text());
					count = count + 1;
					st.setId(count + "");
					sections.add(st);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sections;
	}

	public Section getSectionContent(Section section) {
		try {
			Document doc = Jsoup.connect(section.getUrl())
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
					.timeout(10000).get();
			Element content = doc.getElementById("content");
			// content.select("#text").remove();
			content.getElementsByTag("table").remove();
			content.getElementsByTag("p").remove();
			content.getElementsByTag("a").remove();
			content = content.select(".text").get(0);
			String text = content.html();
			text = text.replaceAll("&nbsp;", "").replaceAll("www.83Kxs.com", "").replaceAll("\n", "")
					.replaceAll("<br><br>", NEWLINE).replaceAll("<br>", "");
			text = NEWLINE + section.getName() + NEWLINE + text + NEWLINE + "--------------------------------------" + NEWLINE;
			section.setCentent(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return section;
	}

	public boolean outputSection(Book book, Section section, String type) {
		boolean status = true;
		try {
			writer = new FileWriter(filePaht + book.getName() + ".txt", true);
			writer.append(section.getCentent());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				writer.close();
			} catch (IOException e1) {
				status = false;
				e1.printStackTrace();
			}
			status = false;
			e.printStackTrace();
		}
		return status;
	}

}
