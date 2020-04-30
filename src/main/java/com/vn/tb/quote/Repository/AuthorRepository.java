package com.vn.tb.quote.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	@Query(value = "SELECT * FROM author ORDER BY featured DESC LIMIT :offset, :per_page ", nativeQuery = true)
	List<Author> getAuthors(int offset, int per_page);
}
