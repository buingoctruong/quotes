package com.vn.tb.quote.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView Quotes(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
	        @RequestParam(value = "per_page", required = true, defaultValue = "50") int per_page,
	        ModelAndView modelAndView) {
		List<Quote> lstQuotes = quoteService.getQuotes(page, per_page);
		modelAndView.addObject("lstQuotes", lstQuotes);
		modelAndView.setViewName("quotes");
		return modelAndView;
	}
}
