package com.vn.tb.quote.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	// MySQL : SELECT * FROM author ORDER BY featured DESC LIMIT :offset, :per_page
	// Postgres: SELECT * FROM author ORDER BY featured DESC LIMIT :per_page OFFSET :offset 
	@Query(value = "SELECT * FROM author ORDER BY featured DESC LIMIT :per_page OFFSET :offset ", nativeQuery = true)
	List<Author> getAuthors(int offset, int per_page);
	
	@Query(value="SELECT name, image from author a where a.link =:authorLink", nativeQuery=true)
	List<Object[]> getAuthorNameAndImage(String authorLink);
}
