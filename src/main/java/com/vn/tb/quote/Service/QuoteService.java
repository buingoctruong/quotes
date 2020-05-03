package com.vn.tb.quote.Service;

import java.util.List;

import com.vn.tb.quote.Model.Quote;

public interface QuoteService {
	List<Quote> getQuotes(int page, int per_page);
	
	List<Quote> findByCollection(String collection, int page, int per_page);
	
	List<Quote> findByTopic(String topic, int page, int per_page);
	
	List<Quote> findByAuthor(String author, int page, int per_page);
}
