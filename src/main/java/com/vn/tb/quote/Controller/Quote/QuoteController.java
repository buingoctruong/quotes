package com.vn.tb.quote.Controller.Quote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Repository.QuoteRepository;
import com.vn.tb.quote.Service.QuoteService;

@RestController
@RequestMapping(value = "/quotes")
public class QuoteController {
	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Quotes(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Quote> lstQuotes = quoteService.getQuotes(defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", "Quote");
		modelAndView.addObject("imageLink", "/static/assets/img/quote-header.jpg");
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("quotes/quotes");
		return modelAndView;
	}
}
