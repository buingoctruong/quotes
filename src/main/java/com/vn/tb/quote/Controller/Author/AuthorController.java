package com.vn.tb.quote.Controller.Author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Authors(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		List<Author> lstAuthors = authorService.getAuthors(defaultPage, defaultPerPage);
		modelAndView.addObject("lstAuthors", lstAuthors);
		modelAndView.setViewName("authors");
		return modelAndView;
	}
}
