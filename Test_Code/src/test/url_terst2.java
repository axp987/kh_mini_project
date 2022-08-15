package test;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class url_terst2 {

	public static void main(String[] args) {
		String url = "https://vibe.naver.com/chart/total";
		Document doc = null;
		
		
		try {
			doc = Jsoup.connect(url).get();
			Elements elements = doc.select("div.tracklist");
			Iterator<Element> title = elements.select("a.title").iterator();
			Iterator<Element> artist = elements.select("span.text").iterator();
			Iterator<Element> rank = elements.select("span.text").iterator();
			while(rank.hasNext()) {
				System.out.println(rank.next().text() + "À§ " + artist.next().text() + " - " + title.next().text());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
