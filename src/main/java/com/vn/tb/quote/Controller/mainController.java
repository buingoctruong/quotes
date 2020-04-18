package com.vn.tb.quote.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class mainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
