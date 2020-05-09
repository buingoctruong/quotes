package com.vn.tb.quote.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.tb.quote.DTO.SearchResultDTO;
import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Repository.CollectionRepository;
import com.vn.tb.quote.Service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	CollectionRepository collectionRepository;
	
	@Override
	public List<Collection> getCollections(int page, int per_page) {
		int offset = (page-1) * per_page;
		return collectionRepository.getCollections(offset, per_page);
	}
	
	@Override
	public List<Object[]> getCollectionNameAndImage(String collectionLink) {
		return collectionRepository.getCollectionNameAndImage(collectionLink);
	}
	
	@Override
	public List<Object> findCollectionBySearchContent(String searchContent) {
		return collectionRepository.findCollectionBySearchContent(searchContent);
	}
}
