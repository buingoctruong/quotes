package com.vn.tb.quote.CrawlData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	CrawlAuthorData crawlAuthorData;
	
	@Autowired
	CrawlCollectionData crawlCollectionData;
	
	@Autowired
	CrawlTopicData crawlTopicData;
	
	@Autowired
	CrawlQuoteData crawlQuoteData;
	
	@Scheduled(fixedRate = 1000000000)
	public void reportCurrentTime() {
		log.info("the crawl is started");
		try {
			// max page is 156
			for (int pageAuthor = 1; pageAuthor <= 1; pageAuthor++) {
				crawlAuthorData.callAuthorAPI(pageAuthor);
			}
			
			crawlCollectionData.callCollectionAPI();
			
			// max page is 21
			for (int pageTopic = 1; pageTopic <= 1; pageTopic++) {
				crawlTopicData.callTopicAPI(pageTopic);
			}
//						
			log.info("the crawl is finished");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error when configuring crawler4j : " + e);
		}
	}
}
