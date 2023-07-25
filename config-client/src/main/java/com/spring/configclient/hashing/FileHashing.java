package com.spring.configclient.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class FileHashing {
	
    public String generateHash(String str) {
      try {
          MessageDigest md = MessageDigest.getInstance("SHA-256");
          
          byte[] inputBytes = str.getBytes(StandardCharsets.UTF_8);          

          // Get the hash value as a byte array
          byte[] hashBytes = md.digest(inputBytes);

          // Convert the byte array to a hexadecimal string
          StringBuilder sb = new StringBuilder();
          for (byte b : hashBytes) {
              sb.append(String.format("%02x", b));
          }
          String hash = sb.toString();

          return hash;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
  
  public boolean verifyHash(String str, String originalHash) {
  	String newHash = generateHash(str);
	
  	if(newHash.equals(originalHash))
  		return true;
  	else 
  		return false;
  }



}
