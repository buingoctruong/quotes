package com.vn.tb.quote.Controller.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Service.TopicService;

@RestController
@RequestMapping(value = "/quote/v1/topics")
public class TopicAPIController {
	@Autowired
	TopicService topicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Topic>> getListTopics(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
	        @RequestParam(value = "per_page", required = false, defaultValue = "60") int per_page) {
		try {
			List<Topic> lstTopics = topicService.getTopics(page, per_page);
			
			return new ResponseEntity<List<Topic>>(lstTopics, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Topic>>(HttpStatus.BAD_REQUEST);
	}
}
