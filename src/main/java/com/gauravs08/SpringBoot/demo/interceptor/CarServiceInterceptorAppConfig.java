package com.gauravs08.SpringBoot.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Gaurav Sharma
 *
 */
@Component
public class CarServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
	   @Autowired
	   CarServiceInterceptor carServiceInterceptor;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(carServiceInterceptor);
	      
	      // Old Login url, no longer use. // Use OldURLInterceptor to redirect to a new URL 
	      registry.addInterceptor(new CarOldInterceptor())//
		  .addPathPatterns("/api/oldCars");
		  
		  // This interceptor apply to URL like /admin/* // Exclude /admin/oldLogin
		  registry.addInterceptor(new CarServiceInterceptor())//
		  .addPathPatterns("/api/*")
		  .excludePathPatterns("/api/oldCars");
	   }
	}