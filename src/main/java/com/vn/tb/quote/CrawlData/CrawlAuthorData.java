package com.vn.tb.quote.CrawlData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Repository.AuthorRepository;
import com.vn.tb.quote.Repository.QuoteRepository;

@Component
public class CrawlAuthorData {
	public static final String api = "https://api.quotery.com/wp-json/quotery/v1/authors?orderby=popular&";
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	CrawlQuoteData crawlQuoteData;
	
	public void callAuthorAPI(int pageAuthor) {
		HttpURLConnection getConnection = null;
		try {
			String url = api + URLEncoder.encode("page", "UTF-8") + "=" + pageAuthor;
	        
		    url += "&" + URLEncoder.encode("per_page", "UTF-8") + "=" + 12;
		    
			URL authorRequest = new URL(url);
		    String readLine = null;
		    getConnection = (HttpURLConnection) authorRequest.openConnection();
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
	            Author author = new Author();
	            author.setName(jsonobject.getString("name"));
	            author.setLink(jsonobject.getString("link"));
	            author.setFeatured(jsonobject.getInt("featured"));
	            author.setCount(jsonobject.getInt("count"));
	            author.setImage(jsonobject.getJSONObject("image").get("url").toString());
	            author.setBirthday(jsonobject.getString("birthday"));
	            author.setProfile(jsonobject.getString("body"));
	            
	            Set<Quote> lstQuotes = new HashSet<Quote>();
	            
	            for (int pageQuote = 1; pageQuote <= 18; pageQuote++) {
	            	List<Quote> lst = crawlQuoteData.callQuoteAPIWithAuthor(getSlugName(jsonobject.getString("link")), 
	            			pageQuote, author);
	            	
	            	if (!lst.isEmpty()) {
	            		lstQuotes.addAll(lst);
	            	} else {
	            		break;
	            	}
	            }
	            
	            author.setQuotes(lstQuotes);
	            
	            authorRepository.save(author);
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
