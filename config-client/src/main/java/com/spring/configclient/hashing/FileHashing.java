package com.spring.configclient.hashing;

import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class FileHashing {
	
    public String generateHash(File file) {
      try {
          MessageDigest md = MessageDigest.getInstance("SHA-256");
          FileInputStream fin = new FileInputStream(file);
          DigestInputStream dis = new DigestInputStream(fin, md);

          // Read the file contents
          byte[] buffer = new byte[4096];
          while (dis.read(buffer) != -1) {
              // Reading the file, but we don't need to do anything here
          }

          // Get the hash value as a byte array
          byte[] hashBytes = md.digest();

          // Convert the byte array to a hexadecimal string
          StringBuilder sb = new StringBuilder();
          for (byte b : hashBytes) {
              sb.append(String.format("%02x", b));
          }
          String hash = sb.toString();

          System.out.println("MD5 hash: " + hash);

          dis.close();
          return hash;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
  
  public boolean verifyHash(File file, String originalHash) {
  	String newHash = generateHash(file);
  	
  	System.out.println("Original Hash : " + originalHash);
	System.out.println("New Hash : " + newHash);
	
  	if(newHash.equals(originalHash))
  		return true;
  	else 
  		return false;
  }



}
