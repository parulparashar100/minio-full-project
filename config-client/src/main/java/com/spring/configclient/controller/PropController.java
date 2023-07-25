package com.spring.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.configclient.properties.ConfigurationProperties;
import com.spring.configclient.service.MainService;

@RestController
public class PropController {

	@Autowired
	private ConfigurationProperties prop;

	@Autowired
	MainService service;
	
	@Autowired
	Environment env;

	@GetMapping("value")
	public String getMessage() {
//		return prop.getMessage();
		return env.getProperty("B1");
	}

	@GetMapping("test")
	public String testMethod() throws Exception {
//		return service.pushFile("filename", "destinationFileName", "destinationFilePath", null, "file input",
//				"bucketName", "secretKey", "accessKey");
		return service.pullFile("filename", "flePath", "UUID", "bucketName", "secretKey", "accessKey");
	}

}
