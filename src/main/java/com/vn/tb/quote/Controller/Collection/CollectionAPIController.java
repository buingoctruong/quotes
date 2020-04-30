package com.vn.tb.quote.Controller.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Service.CollectionService;

@RestController
@RequestMapping(value = "/quote/v1/collections")
public class CollectionAPIController {
	@Autowired
	CollectionService collectionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Collection>> getListCollections(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page,
	        @RequestParam(value = "per_page", required = false, defaultValue = "60") int per_page) {
		try {
			List<Collection> lstCollections = collectionService.getCollections(page, per_page);
			
			return new ResponseEntity<List<Collection>>(lstCollections, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Collection>>(HttpStatus.BAD_REQUEST);
	}
}
