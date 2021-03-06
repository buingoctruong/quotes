package com.vn.tb.quote.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.tb.quote.Model.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer>{
	// MySQL: SELECT * FROM collection LIMIT :offset, :per_page 
	// Postgres: SELECT * FROM collection LIMIT :per_page OFFSET :offset 
	@Query(value = "SELECT * FROM collection LIMIT :offset, :per_page ", nativeQuery = true)
	List<Collection> getCollections(int offset, int per_page);
	
	@Query(value="SELECT name, image from collection c where c.link =:collectionLink", nativeQuery=true)
	List<Object[]> getCollectionNameAndImage(String collectionLink);
	
	@Query(value="SELECT name, link from collection c where c.name like %:searchContent%", nativeQuery=true)
	List<Object> findCollectionBySearchContent(String searchContent);
}
