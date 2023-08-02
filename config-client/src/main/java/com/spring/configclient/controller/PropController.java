package com.spring.configclient.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.configclient.properties.ConfigurationProperties;
import com.spring.configclient.service.MainService;
import com.spring.configclient.template.ResponseData;

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

	@GetMapping("push")
	public String pushTest() throws Exception {
//		return service.pushFile("filename", "destinationFileName", "destinationFilePath", null, "file input",
//				"bucketName", "secretKey", "accessKey");
		//converting file to base64
	    String filePath_1 = "C:\\Users\\parulp\\Pictures\\Screenshots\\Screenshot (3).png";
	    File file = new File(filePath_1);
		byte[] fileBytes = new byte[(int) file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(fileBytes);
		fileInputStream.close();

		// Step 2: Encode the bytes into Base64 representation.
		String base64String = Base64.getEncoder().encodeToString(fileBytes);
	    
		Map<String, String> metaData = new HashMap<String, String>();
		metaData.put("created By", "Parul Parashar");
		
	    // Return success response
	    String uuid = service.pushFile("abc", null, null, metaData, base64String, "codetesting", "6xoaDZuQWQHigfcRyUeTTNLsEjVwlIBtO3DTyy99", "6VkuQjw3Dz99sC4GtVh4");
	    return uuid;
	}
	
	@GetMapping("pull")
	public String pullTest() throws Exception {
		return service.pullFile("abc", null, "2f13e8be-f5f3-46ed-b4ce-941be2ec95e5", "codetesting", "6xoaDZuQWQHigfcRyUeTTNLsEjVwlIBtO3DTyy99", "6VkuQjw3Dz99sC4GtVh4");
	}

}
