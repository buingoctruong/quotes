package com.vn.tb.quote.Service;

import java.util.List;

import com.vn.tb.quote.Model.Quote;

public interface QuoteService {
	List<Quote> getQuotes(int page, int per_page);
}
