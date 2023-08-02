package com.spring.configclient.template;

public class ResponseData {
	private String status;
    private String message;
	public ResponseData() {
		
	}
	public ResponseData(String status, String message) {
		this.status = "Success";
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseData [status=" + status + ", message=" + message + "]";
	}
	
	
    
    

}
