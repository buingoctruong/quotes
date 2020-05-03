package com.vn.tb.quote.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Repository.AuthorRepository;
import com.vn.tb.quote.Service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAuthors(int page, int per_page) {
		int offset = (page-1) * per_page;
		return authorRepository.getAuthors(offset, per_page);
	}
	
	@Override
	public List<Object[]> getAuthorNameAndImage(String authorLink) {
		return authorRepository.getAuthorNameAndImage(authorLink);
	}
}
