package com.vn.tb.quote.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Repository.QuoteRepository;

@RestController
@RequestMapping(value = "/quotes")
public class QuoteController {
	@Autowired
	QuoteRepository quoteRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getListQuotes(ModelAndView modelAndView) {
		List<Quote> lstQuotes = quoteRepository.findAll();
		lstQuotes = lstQuotes.subList(0, 7);
		modelAndView.addObject("lstQuotes", lstQuotes);
		modelAndView.setViewName("quotes");
		return modelAndView;
	}
}
