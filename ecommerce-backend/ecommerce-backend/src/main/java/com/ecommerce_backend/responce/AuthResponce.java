package com.ecommerce_backend.responce;

public class AuthResponce {

	private String jwt;
	private String message;
	public AuthResponce() {
		super();
		this.jwt = jwt;
		this.message = message;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
