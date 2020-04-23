package com.vn.tb.quote.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Service.QuoteService;

@RestController
@RequestMapping(value = "/quote/v1")
public class APIController {
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(value = "/quotes", method = RequestMethod.GET)
	public ResponseEntity<List<Quote>> getListQuotes(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
	        @RequestParam(value = "per_page", required = false, defaultValue = "60") int per_page) {
		try {
			List<Quote> lstQuotes = quoteService.getQuotes(page, per_page);
			return new ResponseEntity<List<Quote>>(lstQuotes, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Quote>>(HttpStatus.BAD_REQUEST);
	}
}
