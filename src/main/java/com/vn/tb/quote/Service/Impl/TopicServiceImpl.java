package com.vn.tb.quote.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Repository.TopicRepository;
import com.vn.tb.quote.Service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	@Autowired
	TopicRepository topicRepository;
	
	@Override
	public List<Topic> getTopics(int page, int per_page) {
		int offset = (page-1) * per_page;
		return topicRepository.getTopics(offset, per_page);
	}
	
	@Override
	public List<Object[]> getTopicNameAndImage(String topicLink) {
		return topicRepository.getTopicNameAndImage(topicLink);
	}
}
