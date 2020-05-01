package com.vn.tb.quote.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer>{
	@Query(value = "SELECT * FROM topic LIMIT :offset, :per_page ", nativeQuery = true)
	List<Topic> getTopics(int offset, int per_page);
	
	@Query(value="SELECT name, image from topic t where t.link =:topicLink", nativeQuery=true)
	List<Object[]> getTopicNameAndImage(String topicLink);
}
