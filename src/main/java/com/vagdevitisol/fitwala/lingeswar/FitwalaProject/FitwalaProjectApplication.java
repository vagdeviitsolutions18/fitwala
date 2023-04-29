package com.vagdevitisol.fitwala.lingeswar.FitwalaProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitwalaProjectApplication {	
	
         static Logger logger = LogManager.getLogger(FitwalaProjectApplication.class);	
	
	public static void main(String[] args) {
		SpringApplication.run(FitwalaProjectApplication.class, args);
		
	System.out.println("Hello Log4j!...");

			logger.debug("My Debug Log");
			logger.info("My Info Log");
			logger.warn("My Warn Log");
			logger.error("My error log");
			logger.fatal("My fatal log");
					
		}
	
	}

