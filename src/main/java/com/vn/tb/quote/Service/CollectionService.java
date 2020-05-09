package com.vn.tb.quote.Service;

import java.util.List;

import com.vn.tb.quote.DTO.SearchResultDTO;
import com.vn.tb.quote.Model.Collection;

public interface CollectionService {
	List<Collection> getCollections(int page, int per_page);
	
	List<Object[]> getCollectionNameAndImage(String collectionLink);
	
	List<Object> findCollectionBySearchContent(String searchContent);
}
