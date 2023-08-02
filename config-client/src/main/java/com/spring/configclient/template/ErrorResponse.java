package com.spring.configclient.template;

//ErrorResponse.java
public class ErrorResponse {
 private String status;
 private String error;

 public ErrorResponse(String error) {
     this.status = "Error";
     this.error = error;
 }

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getError() {
	return error;
}

public void setError(String error) {
	this.error = error;
}

 
 // Getters and setters (you can use Lombok to generate them)
}
