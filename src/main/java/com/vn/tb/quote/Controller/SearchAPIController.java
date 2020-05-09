package com.vn.tb.quote.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.tb.quote.DTO.SearchResultDTO;
import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Model.Topic;
import com.vn.tb.quote.Service.AuthorService;
import com.vn.tb.quote.Service.CollectionService;
import com.vn.tb.quote.Service.QuoteService;
import com.vn.tb.quote.Service.TopicService;

@RestController
@RequestMapping(value = "/quote/v1/search")
public class SearchAPIController {
	@Autowired
	AuthorService authorService;
	
	@Autowired
	QuoteService quoteService;
	
	@Autowired
	CollectionService collectionService;
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<SearchResultDTO>>> search(
			@RequestParam(value = "search", required = true) String searchContent) {
		try {
			Map<String, List<SearchResultDTO>> lstResult = new HashMap<String, List<SearchResultDTO>>();
			
//			List<SearchResultDTO> lstAuthors = authorService.findAuthorBySearchContent(searchContent);
//			List<SearchResultDTO> lstQuotes = quoteService.findQuoteBySearchContent(searchContent);
//			List<SearchResultDTO> lstCollections = collectionService.findCollectionBySearchContent(searchContent);
//			List<SearchResultDTO> lstTopics = topicService.findTopicBySearchContent(searchContent);
//			
//			lstResult.put("authors", lstAuthors);
//			lstResult.put("collections", lstCollections);
//			lstResult.put("quotes", lstQuotes);
//			lstResult.put("topics", lstTopics);
						
			return new ResponseEntity<Map<String, List<SearchResultDTO>>>(lstResult, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, List<SearchResultDTO>>>(HttpStatus.BAD_REQUEST);
	}
}
