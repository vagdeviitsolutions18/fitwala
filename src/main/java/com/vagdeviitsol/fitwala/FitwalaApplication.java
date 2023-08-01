package com.vagdeviitsol.fitwala;




import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitwalaApplication {
	 private static final Logger logger = Logger.getLogger(FitwalaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FitwalaApplication.class, args);

		System.out.println("Hello log!... ");
		logger.debug("This is an info message");
		logger.info("info messaeg");
		logger.warn("info messaeg");
		logger.error("info messaeg");
	}
}
