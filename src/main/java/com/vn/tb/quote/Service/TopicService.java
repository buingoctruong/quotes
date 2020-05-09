package com.vn.tb.quote.Service;

import java.util.List;

import com.vn.tb.quote.Model.Topic;

public interface TopicService {
	List<Topic> getTopics(int page, int per_page);
	
	List<Object[]> getTopicNameAndImage(String topicLink);
	
	List<Object> findTopicBySearchContent(String searchContent);
}
