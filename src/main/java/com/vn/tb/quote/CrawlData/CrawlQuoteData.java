package com.vn.tb.quote.CrawlData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Repository.QuoteRepository;

@Component
public class CrawlQuoteData {
	public static final String api = "https://api.quotery.com/wp-json/quotery/v1/quotes?";
	
	@Autowired
	QuoteRepository quoteRepository;
	
	public List<Quote> callQuoteAPIWithAuthor(String nickName, int page, Author author) {
		HttpURLConnection getConnection = null;
		List<Quote> lst = new ArrayList<Quote>();
		try {
			String url = api + URLEncoder.encode("author", "UTF-8") + "=" + nickName;
	        
		    url += "&" + URLEncoder.encode("orderby", "UTF-8") + "=popular";
		    
		    url += "&" + URLEncoder.encode("page", "UTF-8") + "=" + page;
		    
		    url += "&" + URLEncoder.encode("per_page", "UTF-8") + "=" + 120;
		    		    
			URL quoteRequest = new URL(url);
		    String readLine = null;
		    getConnection = (HttpURLConnection) quoteRequest.openConnection();
		    getConnection.setRequestMethod("GET");
		    getConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36");
		    
		    if (getConnection.getResponseCode() == 200) {
		    	BufferedReader reader = new BufferedReader(
			            new InputStreamReader(getConnection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = reader.readLine()) != null) {
		            response.append(readLine);
		        }
		        reader.close();
		        	        
		        JSONObject objResponse = new JSONObject(response.toString());
		        Object quotes = objResponse.get("quotes");
		        JSONArray objResult = new JSONArray(quotes.toString());
		        		        		        
		        for (int i = 0; i < objResult.length(); i++) {
		            JSONObject jsonobject = objResult.getJSONObject(i);
		            Quote quote = new Quote();
		            quote.setContent(jsonobject.getString("body"));
		            quote.setAuthor(author);
		            
		            lst.add(quote);
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection != null) {
				getConnection.disconnect();
            }
		}
		return lst;
	}
	
	@Transactional
	public List<Quote> callQuoteAPIWithCollection(String collectionSlugName, int page, Collection collection) {
		HttpURLConnection getConnection = null;
		List<Quote> lst = new ArrayList<Quote>();
		try {
			String url = api + URLEncoder.encode("collection", "UTF-8") + "=" + collectionSlugName;
	        
		    url += "&" + URLEncoder.encode("orderby", "UTF-8") + "=popular";
		    
		    url += "&" + URLEncoder.encode("page", "UTF-8") + "=" + page;
		    // Max is 120
		    url += "&" + URLEncoder.encode("per_page", "UTF-8") + "=" + 100;
		    		    
			URL quoteRequest = new URL(url);
		    String readLine = null;
		    getConnection = (HttpURLConnection) quoteRequest.openConnection();
		    getConnection.setRequestMethod("GET");
		    getConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36");
		    
		    if (getConnection.getResponseCode() == 200) {
		    	BufferedReader reader = new BufferedReader(
			            new InputStreamReader(getConnection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = reader.readLine()) != null) {
		            response.append(readLine);
		        }
		        reader.close();
		        
		        JSONArray objResult = new JSONArray(response.toString());
		        		        
		        for (int i = 0; i < objResult.length(); i++) {
		            JSONObject jsonobject = objResult.getJSONObject(i);
		            
		            String content = jsonobject.getString("body");

		            List<Quote> existQuote = quoteRepository.findByContent(content);
		            		            
		            if (0 != existQuote.size()) {
		            	existQuote.get(0).getCollections().add(collection);
		            	lst.add(existQuote.get(0));
		            } else {
		            	Quote quote = new Quote();
			            quote.setContent(content);
			            quote.getCollections().add(collection);
			            
			            lst.add(quote);
		            }
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection != null) {
				getConnection.disconnect();
            }
		}
		return lst;
	}
	
	@Transactional
	public List<Quote> callQuoteAPIWithTopic(String topicSlugName, int page, Topic topic) {
		HttpURLConnection getConnection = null;
		List<Quote> lst = new ArrayList<Quote>();
		try {
			String url = api + URLEncoder.encode("topic", "UTF-8") + "=" + topicSlugName;
	        
		    url += "&" + URLEncoder.encode("orderby", "UTF-8") + "=popular";
		    
		    url += "&" + URLEncoder.encode("page", "UTF-8") + "=" + page;
		    
		    url += "&" + URLEncoder.encode("per_page", "UTF-8") + "=" + 120;
		    		    
			URL quoteRequest = new URL(url);
		    String readLine = null;
		    getConnection = (HttpURLConnection) quoteRequest.openConnection();
		    getConnection.setRequestMethod("GET");
		    getConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36");
		    
		    if (getConnection.getResponseCode() == 200) {
		    	BufferedReader reader = new BufferedReader(
			            new InputStreamReader(getConnection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = reader.readLine()) != null) {
		            response.append(readLine);
		        }
		        reader.close();
		        	        
		        JSONObject objResponse = new JSONObject(response.toString());
		        Object quotes = objResponse.get("quotes");
		        JSONArray objResult = new JSONArray(quotes.toString());
		        		        
		        for (int i = 0; i < objResult.length(); i++) {
		            JSONObject jsonobject = objResult.getJSONObject(i);
		            
		            String content = jsonobject.getString("body");

		            List<Quote> existQuote = quoteRepository.findByContent(content);
		            
		            if (0 != existQuote.size()) {
		            	existQuote.get(0).getTopics().add(topic);
		            	lst.add(existQuote.get(0));
		            } else {
		            	Quote quote = new Quote();
			            quote.setContent(content);
			            quote.getTopics().add(topic);
			            
			            lst.add(quote);
		            }
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection != null) {
				getConnection.disconnect();
            }
		}
		return lst;
	}
}
