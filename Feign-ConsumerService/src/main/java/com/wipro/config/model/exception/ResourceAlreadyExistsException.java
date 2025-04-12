package com.wipro.config.model.exception;

public class ResourceAlreadyExistsException extends Exception{
	public ResourceAlreadyExistsException() {
		super();
	}
	
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
