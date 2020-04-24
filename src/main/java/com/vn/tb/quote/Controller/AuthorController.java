package com.vn.tb.quote.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView Authors(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
	        @RequestParam(value = "per_page", required = true, defaultValue = "60") int per_page,
	        ModelAndView modelAndView) {
		List<Author> lstAuthors = authorService.getAuthors(page, per_page);
		modelAndView.addObject("lstAuthors", lstAuthors);
		modelAndView.setViewName("authors");
		return modelAndView;
	}
}
