package com.vn.tb.quote.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
	@Query(value = "SELECT * FROM quote LIMIT :offset, :per_page ", nativeQuery = true)
	List<Quote> getQuotes(int offset, int per_page);
}
