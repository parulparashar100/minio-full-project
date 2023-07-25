package com.spring.configclient.minio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;

@Component
public class MinioConnection {
	
//    public static void main(String[] args) throws Exception {
//        String accessKey = "IPzZVdNsoeH1wZRiFrjS";
//        String secretKey = "5ZuPNAUSh5HhuP5wnCFxQ9t9VHWGZEsdEhMYhJKN";
//     // Set the bucket name you want to use
//        String bucketName = "your-bucket-name"; 
//     // Set the object name you want to use
//        String objectName = "your-object-name"; 
//     // Set the content you want to upload
//        String str = "Hello, Minio!"; 
//
//        MinioClient minioClient = minioClient(accessKey, secretKey);
//        minioClient.pullObject(bucketName, objectName);
//        minioClient.pushObject(bucketName, objectName, str);
//    }

    public static MinioClient minioClient;

    public static MinioClient minioClient(String accessKey, String secretKey) throws Exception {
        if (minioClient == null) {
            minioClient = MinioClient.builder()
                    .endpoint("http://10.101.104.140:9001")
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
        InputStream stream = new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));

        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(stream, stream.available(), -1)
                .build());
        System.out.println(objectName + " is Successfully uploaded to " + bucketName);
    }
}
