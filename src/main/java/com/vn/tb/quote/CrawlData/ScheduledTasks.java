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
	CrawlQuoteData crawlQuoteData;
	
	@Scheduled(fixedRate = 1000000000)
	public void reportCurrentTime() {
		log.info("the crawl is started");
		try {
			
			for (int pageAuthor = 0; pageAuthor <= 156; pageAuthor++) {
				crawlAuthorData.callAuthorAPI(pageAuthor);
			}
			log.info("the crawl is finished");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error when configuring crawler4j : " + e);
		}
	}
}
