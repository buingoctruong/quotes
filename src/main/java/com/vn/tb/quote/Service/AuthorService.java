package com.vn.tb.quote.Service;

import java.util.List;

import com.vn.tb.quote.Model.Author;

public interface AuthorService {
	List<Author> getAuthors(int page, int per_page);
	
	List<Object[]> getAuthorNameAndImage(String authorLink);
}
