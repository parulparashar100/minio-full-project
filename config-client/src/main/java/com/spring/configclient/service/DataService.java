package com.spring.configclient.service;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import com.spring.configclient.hashing.FileHashing;

public class DataService {
	
	//Autowire minio class
	//Autowire mysql class
	//Autowire encryption class
	//Autowire CockroachDB class
	
	//Autowire Hashing class
	private FileHashing fileHashing;

	public String pushFile(String filename, String destinationFileName, String destinationFilePath,
			Map<String, String> metadata, File data, String bucketName, String secretKey, String accessKey) {
		
		//Generate hash
		String hash = fileHashing.generateHash(data);

		//check for encryption
			//encrypt file
			//generate encrypted hash
			String encryptedHash = fileHashing.generateHash(data);
		
		//generate UUID for file name
		UUID uuidName = UUID.randomUUID();
		
		//push on minio
		
		//generate UUID for database
		UUID uuidKey = UUID.randomUUID();
		
		//check for database
			//insert data in mysql or cockroachDB
		
		//return UUID
		return null;
	}

	public File pullFile(String fileName, String filePath, String UUID, String bucketName, String secretKey,
			String accessKey) {
		//get details of the file from database
		//pull file from minio
		//check encryption flag
			//check encrypted hash
			//decrypt the file
		//check decrypted hash
		
		//return file
		return null;
	}

}
