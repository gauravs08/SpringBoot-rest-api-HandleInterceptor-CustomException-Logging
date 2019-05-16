package com.gauravs08.SpringBoot.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gauravs08.SpringBoot.demo.model.Car;

/**
 * @author Gaurav Sharma
 *
 */
@RestController
public class CarRestTempletWebService {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template/cars")
	public String getCarList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println("======In CarRestTempletWebService /template/cars Exchange to=> /api/cars===\n");
		return restTemplate.exchange("http://localhost:8080/api/cars", HttpMethod.GET, entity, String.class).getBody();
	}

	@RequestMapping(value = "/template/cars", method = RequestMethod.POST)
	public String createCars(@RequestBody Car car) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Car> entity = new HttpEntity<Car>(car, headers);
		System.out.println("======In CarRestTempletWebService /template/cars Exchange to=> /api/cars===\n");
		
		return restTemplate.exchange("http://localhost:8080/api/cars", HttpMethod.POST, entity, String.class).getBody();
	}

	@RequestMapping(value = "/template/cars/{id}", method = RequestMethod.PUT)
	public String updateCar(@PathVariable("id") String id, @RequestBody Car car) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Car> entity = new HttpEntity<Car>(car, headers);
		System.out.println("======In CarRestTempletWebService /template/cars/{id} Exchange to=> /api/cars/{id}===\n");
		
		return restTemplate.exchange("http://localhost:8080/api/cars/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/template/cars/{id}", method = RequestMethod.DELETE)
	public String deleteCar(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Car> entity = new HttpEntity<Car>(headers);
		System.out.println("======In CarRestTempletWebService /template/cars/{id} Exchange to=> /api/cars/{id}===\n");
		
		return restTemplate.exchange("http://localhost:8080/api/cars/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
