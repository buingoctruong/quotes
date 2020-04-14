package com.vn.tb.quote.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

}
