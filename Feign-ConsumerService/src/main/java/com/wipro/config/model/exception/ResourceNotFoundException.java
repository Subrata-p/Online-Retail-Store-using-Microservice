package com.wipro.config.model.exception;

public class ResourceNotFoundException extends Exception{
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
