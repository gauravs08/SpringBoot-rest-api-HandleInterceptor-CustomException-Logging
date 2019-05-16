package com.gauravs08.SpringBoot.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gauravs08.SpringBoot.demo.Application;
/**
 * @author Gaurav Sharma
 *
 */
@ControllerAdvice
public class CarExceptionController {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	@ExceptionHandler(value = CarNotfoundException.class)
	public ResponseEntity<Object> exception(CarNotfoundException e) {
		logger.error("Car not in Garage:"+e.getMessage());
		return new ResponseEntity<>("Car not in Garage", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CarDuplicateException.class)
	public ResponseEntity<Object> exception(CarDuplicateException e) {
		logger.error("Car Already in Garage:"+e.getMessage());
		return new ResponseEntity<>("Car Already in Garage", HttpStatus.CONFLICT);
	}
}
