package com.example.demo.service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.example.demo.model.News;


@Component
public class NewsService {
	
	private static List<News> newsList = new ArrayList<>();
	
	static {
       //loading rss
		URL feedSource;
		try {
			feedSource = new URL("http://news.google.com/news?pz=1&amp;cf=all&amp;ned=en_il&amp;hl=en&amp;output=rss");
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedSource));
		    ObjectMapper jsonMapper = new ObjectMapper();
			String json = jsonMapper.writeValueAsString(feed);
			 try {
				 //convert rss to list
					newsList = Arrays.asList(jsonMapper.readValue(json, News[].class));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
		} catch (MalformedURLException e) {
					e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	//return new Content
	public  News getNewContent(int id) {
		return newsList.stream()
        .filter(x -> x.getSource().getId()==id)
        .findFirst()
        .orElse(null);
	 
	}
	//return newsList
	public List<News> getTopicList() {
	
		return newsList;
	}
}


