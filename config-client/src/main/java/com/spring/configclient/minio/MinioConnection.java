package com.spring.configclient.minio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.spring.configclient.encryption.EncryptionDecryption;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;

@Component
public class MinioConnection {
	
//    public static void main(String[] args) throws Exception {
//        String accessKey = "6VkuQjw3Dz99sC4GtVh4";
//        String secretKey = "6xoaDZuQWQHigfcRyUeTTNLsEjVwlIBtO3DTyy99";
//     // Set the bucket name you want to use
////        String bucketName = "your-bucket-name"; 
//        String bucketName = "codetesting";
//     // Set the object name you want to use
//        String objectName = "your-object-name"; 
//     // Set the content you want to upload
//        String str = "Hello, Minio!"; 
//
//        MinioConnection conn = new MinioConnection();
//        MinioClient minioClient = minioClient(accessKey, secretKey);
//        conn.pullObject(bucketName, objectName);
//        conn.pushObject(bucketName, objectName, str);
    	
//    	String filePath_1 = "C:\\Users\\parulp\\Pictures\\Screenshots\\Screenshot (3).png";
//	    File file = new File(filePath_1);
//		byte[] fileBytes = new byte[(int) file.length()];
//		FileInputStream fileInputStream = new FileInputStream(file);
//		fileInputStream.read(fileBytes);
//		fileInputStream.close();
//
//		// Step 2: Encode the bytes into Base64 representation.
//		String base64String = Base64.getEncoder().encodeToString(fileBytes);
//	    
//		EncryptionDecryption encrypt = new EncryptionDecryption();
//		String enc = encrypt.encrypt(base64String, "\"This!abcd!Is@My#Encryption%Key\"");
//		System.out.println(base64String);
//		System.out.println();
////		System.out.println(enc);
//	    // Return success response
//		conn.pushObject(bucketName, "abc", enc);
//    }

    public static MinioClient minioClient;

    public static MinioClient minioClient(String accessKey, String secretKey) throws Exception {
        if (minioClient == null) {
            minioClient = MinioClient.builder()
                    .endpoint("http://10.101.104.140:9000")
                    .credentials(accessKey, secretKey)
                    .build();
            System.out.println("Connection to Minio server Successful!");
        }
        return minioClient;
    }

    public String pullObject(String bucketName, String objectName)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String result = "";
        try {
            InputStream stream = minioClient.getObject(GetObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .build());
            // Convert Stream to String

            byte[] buff = new byte[16384];
            int bytesRead;
            while ((bytesRead = stream.read(buff, 0, buff.length)) >= 0) {
                result += new String(buff, 0, bytesRead, StandardCharsets.UTF_8);
            }
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
        return result;
    }

    public void pushObject(String bucketName, String objectName, String str) throws Exception {
        // String to Stream
    	System.out.println("push object method called");
        InputStream stream = new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));

        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(stream, stream.available(), -1)
                .build());
        System.out.println(objectName + " is Successfully uploaded to " + bucketName);
    }
}
