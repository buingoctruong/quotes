package com.vn.tb.quote.Controller.Topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Service.QuoteService;
import com.vn.tb.quote.Service.TopicService;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {
	@Autowired
	TopicService topicService;
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Topics(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Topic> lstTopics = topicService.getTopics(defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", "Quote");
		modelAndView.addObject("imageLink", "https://static.quotery.com/backgrounds/1280/catalog-1280.jpg");
		modelAndView.addObject("lstTopics", lstTopics);
		
		modelAndView.setViewName("topics/topics");
		return modelAndView;
	}
	
	@RequestMapping(value = "/inspiration", method = RequestMethod.GET)
	public ModelAndView Inspiration(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
        
		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/inspiration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/love", method = RequestMethod.GET)
	public ModelAndView Love(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/love");
		return modelAndView;
	}
	
	@RequestMapping(value = "/wisdom", method = RequestMethod.GET)
	public ModelAndView Wisdom(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/wisdom");
		return modelAndView;
	}
	
	@RequestMapping(value = "/life", method = RequestMethod.GET)
	public ModelAndView Life(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/life");
		return modelAndView;
	}
	
	@RequestMapping(value = "/friendship", method = RequestMethod.GET)
	public ModelAndView Friendship(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/friendship");
		return modelAndView;
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView Success(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		modelAndView.addObject("lstQuotes", lstQuotes);
		modelAndView.setViewName("topics/success");
		return modelAndView;
	}
	
	@RequestMapping(value = "/pain", method = RequestMethod.GET)
	public ModelAndView Pain(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/pain");
		return modelAndView;
	}
	
	@RequestMapping(value = "/personality", method = RequestMethod.GET)
	public ModelAndView Personality(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/personality");
		return modelAndView;
	}
	
	@RequestMapping(value = "/happiness", method = RequestMethod.GET)
	public ModelAndView Happiness(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/happiness");
		return modelAndView;
	}
	
	@RequestMapping(value = "/motivation", method = RequestMethod.GET)
	public ModelAndView Motivation(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/motivation");
		return modelAndView;
	}
	
	@RequestMapping(value = "/anger", method = RequestMethod.GET)
	public ModelAndView Anger(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/anger");
		return modelAndView;
	}
	
	@RequestMapping(value = "/behavior", method = RequestMethod.GET)
	public ModelAndView Behavior(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/behavior");
		return modelAndView;
	}
	
	@RequestMapping(value = "/dreams", method = RequestMethod.GET)
	public ModelAndView Dreams(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/dreams");
		return modelAndView;
	}
	
	@RequestMapping(value = "/attitude", method = RequestMethod.GET)
	public ModelAndView Attitude(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/attitude");
		return modelAndView;
	}
	
	@RequestMapping(value = "/hope", method = RequestMethod.GET)
	public ModelAndView Hope(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/hope");
		return modelAndView;
	}
	
	@RequestMapping(value = "/travel", method = RequestMethod.GET)
	public ModelAndView Travel(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/travel");
		return modelAndView;
	}
	
	@RequestMapping(value = "/courage", method = RequestMethod.GET)
	public ModelAndView Courage(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/courage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView Home(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/fear", method = RequestMethod.GET)
	public ModelAndView Fear(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/fear");
		return modelAndView;
	}
	
	@RequestMapping(value = "/appearance", method = RequestMethod.GET)
	public ModelAndView Appearance(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/appearance");
		return modelAndView;
	}
	
	@RequestMapping(value = "/creativity", method = RequestMethod.GET)
	public ModelAndView Creativity(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/creativity");
		return modelAndView;
	}
	
	@RequestMapping(value = "/sadness", method = RequestMethod.GET)
	public ModelAndView Sadness(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/sadness");
		return modelAndView;
	}
	
	@RequestMapping(value = "/family", method = RequestMethod.GET)
	public ModelAndView Family(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/family");
		return modelAndView;
	}
	
	@RequestMapping(value = "/experience", method = RequestMethod.GET)
	public ModelAndView Experience(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/experience");
		return modelAndView;
	}
	
	@RequestMapping(value = "/humanity", method = RequestMethod.GET)
	public ModelAndView Humanity(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/humanity");
		return modelAndView;
	}
	
	@RequestMapping(value = "/honesty", method = RequestMethod.GET)
	public ModelAndView Honesty(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/honesty");
		return modelAndView;
	}
	
	@RequestMapping(value = "/loneliness", method = RequestMethod.GET)
	public ModelAndView Loneliness(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/loneliness");
		return modelAndView;
	}
	
	@RequestMapping(value = "/lying", method = RequestMethod.GET)
	public ModelAndView Lying(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/lying");
		return modelAndView;
	}
	
	@RequestMapping(value = "/wealth", method = RequestMethod.GET)
	public ModelAndView Wealth(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/wealth");
		return modelAndView;
	}
	
	@RequestMapping(value = "/progress", method = RequestMethod.GET)
	public ModelAndView Progress(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/progress");
		return modelAndView;
	}
	
	@RequestMapping(value = "/quitting", method = RequestMethod.GET)
	public ModelAndView Quitting(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/quitting");
		return modelAndView;
	}
	
	@RequestMapping(value = "/giving", method = RequestMethod.GET)
	public ModelAndView Giving(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/giving");
		return modelAndView;
	}
	
	@RequestMapping(value = "/leadership", method = RequestMethod.GET)
	public ModelAndView Leadership(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/leadership");
		return modelAndView;
	}
	
	@RequestMapping(value = "/confidence", method = RequestMethod.GET)
	public ModelAndView Confidence(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/confidence");
		return modelAndView;
	}
	
	@RequestMapping(value = "/strength", method = RequestMethod.GET)
	public ModelAndView Strength(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/strength");
		return modelAndView;
	}
	
	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public ModelAndView Change(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/change");
		return modelAndView;
	}
	
	@RequestMapping(value = "/growth", method = RequestMethod.GET)
	public ModelAndView Growth(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/growth");
		return modelAndView;
	}
	
	@RequestMapping(value = "/patience", method = RequestMethod.GET)
	public ModelAndView Patience(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/patience");
		return modelAndView;
	}
	
	@RequestMapping(value = "/memories", method = RequestMethod.GET)
	public ModelAndView Memories(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/memories");
		return modelAndView;
	}
	
	@RequestMapping(value = "/negativity", method = RequestMethod.GET)
	public ModelAndView Negativity(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/negativity");
		return modelAndView;
	}
	
	@RequestMapping(value = "/peace", method = RequestMethod.GET)
	public ModelAndView Peace(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/peace");
		return modelAndView;
	}
	
	@RequestMapping(value = "/power", method = RequestMethod.GET)
	public ModelAndView Power(ModelAndView modelAndView, HttpServletRequest request) {
		String topicLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = topicService.getTopicNameAndImage(topicLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByTopic(topicLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("topics/power");
		return modelAndView;
	}
}
