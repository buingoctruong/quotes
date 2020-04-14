package com.vn.tb.quote.CrawlData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Model.Quote;

@Component
public class CrawlQuoteData {
	public static final String api = "https://api.quotery.com/wp-json/quotery/v1/quotes?";
	
	public List<Quote> callQuoteAPI(String nickName, int page, Author author) {
		HttpURLConnection getConnection = null;
		List<Quote> lst = new ArrayList<Quote>();
		try {
			String url = api + URLEncoder.encode("author", "UTF-8") + "=" + nickName;
	        
		    url += "&" + URLEncoder.encode("orderby", "UTF-8") + "=popular";
		    
		    url += "&" + URLEncoder.encode("page", "UTF-8") + "=" + page;
		    
		    url += "&" + URLEncoder.encode("per_page", "UTF-8") + "=" + 120;
		    		    
			URL houseRequest = new URL(url);
		    String readLine = null;
		    getConnection = (HttpURLConnection) houseRequest.openConnection();
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
}
