package com.vn.tb.quote.CrawlData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Repository.QuoteRepository;
import com.vn.tb.quote.Repository.TopicRepository;

@Component
public class CrawlTopicData {
	public static final String api = "https://api.quotery.com/wp-json/quotery/v1/topics?orderby=popular&";
	
//	("Inspiration", "Love", "Wisdom", "Friendship", "Life", "Pain", "Success", 
//			"Happiness", "Motivation", "Personality", "Anger", "Dreams", "Attitude", "Behavior", "Hope", "Travel", "Courage", "Home", 
//			"Fear", "Appearance", "Creativity", "Sadness", "Family", "Experience", "Humanity", "Honesty", "Loneliness", "Quitting", 
//			"Giving", "Confidence", "Leadership", "Strength", "Change", "Growth", "Patience", "Memories", "Peace", "Passion", "Youth", 
//			"Victory", "Knowledge", "Money", "Productivity", "Mistakes", "Forgiveness", "Power", "Negativity", "Progress", "Wealth", "Lying")
	
	public static final List<String> include = Arrays.asList("Love", "Life", "Pain", "Success", 
			"Happiness", "Motivation", "Anger", "Dreams", "Fear", "Creativity", "Sadness", 
			"Family", "Experience", "Loneliness", "Quitting", "Giving", "Confidence", "Leadership", 
			"Strength", "Growth", "Patience", "Memories", "Passion", "Knowledge", "Productivity", 
			"Mistakes", "Forgiveness", "Power", "Negativity", "Progress", "Lying");
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	CrawlQuoteData crawlQuoteData;
	
	@Transactional
	public void callTopicAPI(int pageTopic) {
		HttpURLConnection getConnection = null;
		try {
			String url = api + URLEncoder.encode("page", "UTF-8") + "=" + pageTopic;
	        
		    url += "&" + URLEncoder.encode("per_page", "UTF-8") + "=" + 120;
		    
			URL topicRequest = new URL(url);
		    String readLine = null;
		    getConnection = (HttpURLConnection) topicRequest.openConnection();
		    getConnection.setRequestMethod("GET");
		    getConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36");
		    
		    BufferedReader reader = new BufferedReader(
		            new InputStreamReader(getConnection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = reader.readLine()) != null) {
	            response.append(readLine);
	        }
	        reader.close();
	        
	        JSONArray jsonObject = new JSONArray(response.toString());
	        	        
	        for (int i = 0; i < jsonObject.length(); i++) {
	            JSONObject jsonobject = jsonObject.getJSONObject(i);
	            if (include.contains(jsonobject.getString("name"))) {
	            	Topic topic = new Topic();
		            topic.setName(jsonobject.getString("name"));
		            topic.setLink(jsonobject.getString("link"));
		            topic.setCount(jsonobject.getInt("count"));
		            topic.setImage(jsonobject.getJSONObject("image").get("url").toString());
		            topic.setProfile(jsonobject.getString("body"));
		            
		            Set<Quote> lstQuotes = new HashSet<Quote>();
		            
		            for (int pageQuote = 1; pageQuote <= 20; pageQuote++) {
		            	List<Quote> lst = crawlQuoteData.callQuoteAPIWithTopic(getSlugName(jsonobject.getString("link")),
		            			pageQuote, topic);
		            	
		            	if (!lst.isEmpty()) {
		            		lstQuotes.addAll(lst);
		            	} else {
		            		break;
		            	}
		            }
		            topic.getQuotes().addAll(lstQuotes);
		            
		            topicRepository.save(topic);
	            }
	        }	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection != null) {
				getConnection.disconnect();
            }
		}
	}
	
	public String getSlugName(String link) {
		int lastIndex = link.lastIndexOf("/");
		int nearLastIndex = link.lastIndexOf("/", lastIndex - 1);
		
		return link.substring(nearLastIndex+1, lastIndex);
	}
}
