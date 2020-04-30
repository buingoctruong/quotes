package com.vn.tb.quote.Controller.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Service.TopicService;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {
	@Autowired
	TopicService topicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Topics(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		List<Topic> lstTopics = topicService.getTopics(defaultPage, defaultPerPage);
		modelAndView.addObject("lstTopics", lstTopics);
		modelAndView.setViewName("topics");
		return modelAndView;
	}
}
