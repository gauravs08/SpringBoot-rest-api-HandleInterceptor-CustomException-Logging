package com.gauravs08.SpringBoot.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gauravs08.SpringBoot.demo.exception.CarDuplicateException;
import com.gauravs08.SpringBoot.demo.exception.CarNotfoundException;
import com.gauravs08.SpringBoot.demo.model.Car;
/**
 * @author Gaurav Sharma
 *
 */
@RestController
public class CarServiceController {
	private static Map<String, Car> garage = new HashMap<>();
	static {
		Car car = new Car();
		car.setId("1");
		car.setBrand("BMW");
		car.setFuel("Petrol");
		garage.put(car.getId(), car);

		Car mercz = new Car();
		mercz.setId("2");
		mercz.setBrand("Mercedes");
		mercz.setFuel("Electric");
		garage.put(mercz.getId(), mercz);
	}

	// Get all car list
	@RequestMapping(value = "/api/cars")
	public ResponseEntity<Object> getCar() {
		return new ResponseEntity<>(garage.values(), HttpStatus.OK);
	}

	// Get all car list
		@RequestMapping(value = "/api/cars/{id}")
		public ResponseEntity<Object> getCar(@PathVariable("id") String id) {
			//Check if car is in garage
			if(!garage.containsKey(id))throw new CarNotfoundException();
			
			return new ResponseEntity<>(garage.get(id), HttpStatus.OK);
		}
		
	// Post a car in garage
	@RequestMapping(value = "/api/cars", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Car car) {
		if(garage.containsKey(car.getId()))throw new CarDuplicateException();
		
		garage.put(car.getId(), car);
		return new ResponseEntity<>("Car is added to garage", HttpStatus.CREATED);
	}

	// PUT or update a car details
	@RequestMapping(value = "/api/cars/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Car car) {
		 
		if(!garage.containsKey(id))throw new CarNotfoundException();
		
		garage.remove(id);
		car.setId(id);
		garage.put(id, car);
		return new ResponseEntity<>("Car " + car.getBrand() + " is updated successsfully", HttpStatus.OK);
	}

	// Delete a car model
	@RequestMapping(value = "/api/car/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		garage.remove(id);
		return new ResponseEntity<>("Car deleted successsfully from garage", HttpStatus.OK);
	}
}
