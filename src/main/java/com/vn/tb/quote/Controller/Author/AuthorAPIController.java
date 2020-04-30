package com.vn.tb.quote.Controller.Author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Service.AuthorService;

@RestController
@RequestMapping(value = "/quote/v1/authors")
public class AuthorAPIController {
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> getListAuthors(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
	        @RequestParam(value = "per_page", required = false, defaultValue = "60") int per_page) {
		try {
			List<Author> lstAuthors = authorService.getAuthors(page, per_page);
			
			return new ResponseEntity<List<Author>>(lstAuthors, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Author>>(HttpStatus.BAD_REQUEST);
	}
}
