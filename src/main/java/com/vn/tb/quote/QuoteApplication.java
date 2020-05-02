package com.vn.tb.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class QuoteApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuoteApplication.class, args);
	}
}
