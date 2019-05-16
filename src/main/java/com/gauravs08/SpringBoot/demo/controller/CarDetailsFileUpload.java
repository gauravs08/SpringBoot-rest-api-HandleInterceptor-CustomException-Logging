/**
 * 
 */
package com.gauravs08.SpringBoot.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Gaurav Sharma
 *http://localhost:8080/upload
 *No header 
 *Body  select form-data key write file value add a file to upload
 */
@RestController
public class CarDetailsFileUpload {
	@Value("${car.file.path}")
	private String carFilePath;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File(carFilePath + file.getOriginalFilename());
		System.out.println("FIle path:"+convertFile.getPath());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "Car Details File is upload successfully";
	}
}
