package com.supermarketinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SuperMarketApplication 
{
	
	public static void main(String[] args) {
		SpringApplication.run(SuperMarketApplication.class, args);
	}

}
	