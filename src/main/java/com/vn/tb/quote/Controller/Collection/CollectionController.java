package com.vn.tb.quote.Controller.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Service.CollectionService;
import com.vn.tb.quote.Service.QuoteService;

@RestController
@RequestMapping(value = "/collections")
public class CollectionController {
	@Autowired
	CollectionService collectionService;
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Collections(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		List<Collection> lstCollections = collectionService.getCollections(defaultPage, defaultPerPage);
		modelAndView.addObject("lstCollections", lstCollections);
		modelAndView.setViewName("collections");
		return modelAndView;
	}
	
	@RequestMapping(value = "/top-greatest-quotes-all-time", method = RequestMethod.GET)
	public ModelAndView TopGreatestQuotesAllTime(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		String CollectionName = "Top 500 Greatest Quotes Of All Time";
		List<Quote> lstQuotes = quoteService.findByCollection(CollectionName, defaultPage, defaultPerPage);
		modelAndView.addObject("lstQuotes", lstQuotes);
		modelAndView.setViewName("top-greatest-quotes-all-time");
		return modelAndView;
	}
}
