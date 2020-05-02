package com.vn.tb.quote.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
	// MySQL: SELECT * FROM quote LIMIT :offset, :per_page 
	@Query(value = "SELECT * FROM quote LIMIT :per_page OFFSET :offset ", nativeQuery = true)
	List<Quote> getQuotes(int offset, int per_page);
	
	List<Quote> findByContent(String content);
	
	@Query(value = "SELECT * FROM quote q INNER JOIN collection_quote cq ON cq.quote_id = q.id "
			+ "INNER JOIN collection c ON c.id = cq.collection_id "
			+ " WHERE c.link =:link LIMIT :offset, :per_page ", nativeQuery = true)
	List<Quote> findByCollection(String link, int offset, int per_page);
	
	@Query(value = "SELECT * FROM quote q INNER JOIN topic_quote tq ON tq.quote_id = q.id "
			+ "INNER JOIN topic t ON t.id = tq.topic_id "
			+ " WHERE t.link =:link LIMIT :offset, :per_page ", nativeQuery = true)
	List<Quote> findByTopic(String link, int offset, int per_page);
}
