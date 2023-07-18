package com.spring.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.configclient.properties.ConfigurationProperties;

@RestController
public class PropController {

	@Autowired
	private ConfigurationProperties prop;
	
	@GetMapping("value")
	public String getMessage() {
		return prop.getMessage();
	}
	
}
