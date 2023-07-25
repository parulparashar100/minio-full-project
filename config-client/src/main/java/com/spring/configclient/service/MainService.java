package com.spring.configclient.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.configclient.database.entity.Data;
import com.spring.configclient.database.service.impl.BucketServiceImpl;
import com.spring.configclient.database.service.impl.DataServiceImpl;
import com.spring.configclient.encryption.EncryptionDecryption;
import com.spring.configclient.hashing.FileHashing;
import com.spring.configclient.minio.MinioConnection;

@Service
public class MainService {
	
	@Autowired
	private FileHashing fileHashing;
	
	@Autowired
	private EncryptionDecryption encryptionDecryption;
	
	@Autowired
	private MinioConnection minio;
	
	@Autowired
	private DataServiceImpl dataService;
	
	@Autowired
	private BucketServiceImpl bucketService;
	
	public String pushFile(String filename, String destinationFileName, String destinationFilePath,
			Map<String, String> metadata, String fileData, String bucketName, String secretKey, String accessKey)
			throws Exception {
		getProperties();
		String hash = null;
		String encryptedData = null;
		String encryptedHash = null;
		
		try {
			// Generate hash
			hash = fileHashing.generateHash(fileData);
			
			// check for encryption
			if (isEncrypt.equals("true")) {
				// encrypt file
				encryptedData = encryptionDecryption.encrypt(fileData, encryptionKey);
				// generate encrypted hash
				encryptedHash = fileHashing.generateHash(encryptedData);
			}
			// generate UUID for file name
			String uuidName = UUID.randomUUID().toString();
			// push data on minio
			MinioConnection.minioClient(accessKey, secretKey);
			minio.pushObject(bucketName, encryptedData, uuidName);

			// generate UUID for database
			String uuidKey = UUID.randomUUID().toString();

			// check for database
			if (database.equals("mysql")) {
				// insert data in mysql
				Data data = new Data();
				data.setUuid(uuidKey);
				data.setApiFileName(uuidName);
				data.setDestinationFileName(destinationFileName);
				data.setDestinationFilePath(destinationFilePath);
				data.setBucket(bucketName);
				data.setHashFile(hash);
				data.setHashEncFile(encryptedHash);
				data.setMetaData(metadata.toString());
				dataService.saveData(data);
			} else {
				// insert data in cockroachDB
			}

			// return UUID
			return uuidKey;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String pullFile(String fileName, String filePath, String uuid, String bucketName, String secretKey,
			String accessKey) throws Exception {
		getProperties();
		String fileData = null;
		String encryptedData = null;
		Data data = null;
		
		// get details of the file from database
		if (database.equals("mysql")) {
			if(uuid != null)
				data = dataService.getDataByUuid(uuid);
			else if(fileName != null) 
				data = dataService.getDataByApiFileName(fileName);
		} else {
			//cockroachDB here
		}
		
		// pull file from minio
		MinioConnection.minioClient(accessKey, secretKey);
		encryptedData = minio.pullObject(bucketName, data.getApiFileName());
//		encryptedData = encryptionDecryption.encrypt(fileData, encryptionKey);

		// check encryption flag
		if (isEncrypt.equals("true")) {
			
			/*
			 * just for checking mehtod
			 */
//			String tempEncryptedHash = fileHashing.generateHash(encryptedData);
			
			// check encrypted hash
			if (!fileHashing.verifyHash(encryptedData, data.getHashEncFile())) {
				throw new Exception("Internal server error 1");
			}
			// decrypt the file
			fileData = encryptionDecryption.decrypt(encryptedData, encryptionKey);
		}

		/*
		 * just for checking mehtod
		 */
//		String tempHash = fileHashing.generateHash(data);

		// check decrypted hash
		if (!fileHashing.verifyHash(fileData, data.getHashFile())) {
			throw new Exception("Internal server error 2");
		}

		return fileData;
	}
	
	private String isEncrypt;
	private String encryptionKey;
	private String database;

	public void getProperties() {
		Properties prop = new Properties();
		try (InputStream inputStream = MainService.class.getClassLoader()
				.getResourceAsStream("application.properties")) {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		isEncrypt = prop.getProperty("isEncrypt");
		encryptionKey = prop.getProperty("encryptionKey");
		database = prop.getProperty("database");
		
	}

}
