package com.vn.tb.quote.CrawlData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Repository.CollectionRepository;
import com.vn.tb.quote.Repository.QuoteRepository;

@Component
public class CrawlCollectionData {
	public static final String api = "https://api.quotery.com/wp-json/quotery/v1/collections?orderby=popular&page=1&per_page=120";
	
	@Autowired
	CollectionRepository collectionRepository;
	
	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	CrawlQuoteData crawlQuoteData;
	
	@Transactional
	public void callCollectionAPI() {
		HttpURLConnection getConnection = null;
		try {		    
			URL collectionRequest = new URL(api);
		    String readLine = null;
		    getConnection = (HttpURLConnection) collectionRequest.openConnection();
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
	            Collection collection = new Collection();
	            collection.setName(jsonobject.getString("name"));
	            collection.setLink(jsonobject.getString("link"));
	            collection.setCount(jsonobject.getInt("count"));
	            collection.setImage(jsonobject.getJSONObject("image").get("url").toString());
	            collection.setProfile(jsonobject.getString("body"));
	            
	            Set<Quote> lstQuotes = new HashSet<Quote>();
	            
	            // MaxPage is 5
	            for (int pageQuote = 1; pageQuote <= 1; pageQuote++) {
	            	List<Quote> lst = crawlQuoteData.callQuoteAPIWithCollection(getSlugName(jsonobject.getString("link")), 
	            			pageQuote, collection);
	            	
	            	if (!lst.isEmpty()) {
	            		lstQuotes.addAll(lst);
	            	} else {
	            		break;
	            	}
	            }
	            
	            collection.getQuotes().addAll(lstQuotes);
	            
	            collectionRepository.save(collection);
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
