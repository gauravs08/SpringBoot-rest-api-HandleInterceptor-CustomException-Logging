package com.gauravs08.SpringBoot.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {//extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	@Autowired
	   RestTemplate restTemplate;
	
	//@Value("${spring.application.name.notfromprop:Default_Spring_boot}")   // this is default name used if prop is not found 
	@Value("${spring.application.name}")
	private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	   @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();   
	   }
	

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(Application.class); }
	 */
	@RequestMapping(value = "/")
	   public String hello() {
		logger.error("Error In / route");
	      return "Hello Spring Boot "+ name;
	   }
}
