package com.vn.tb.quote.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Repository.QuoteRepository;
import com.vn.tb.quote.Service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService{
	@Autowired
	QuoteRepository quoteRepository;
	
	@Override
	public List<Quote> getQuotes(int page, int per_page) {
		int offset = (page-1) * per_page;
		return quoteRepository.getQuotes(offset, per_page);
	}
	
	@Override
	public List<Quote> findByCollection(String collection, int page, int per_page) {
		int offset = (page-1) * per_page;
		return quoteRepository.findByCollection(collection, offset, per_page);
	}
	
	@Override
	public List<Quote> findByTopic(String collection, int page, int per_page) {
		int offset = (page-1) * per_page;
		return quoteRepository.findByTopic(collection, offset, per_page);
	}
}
