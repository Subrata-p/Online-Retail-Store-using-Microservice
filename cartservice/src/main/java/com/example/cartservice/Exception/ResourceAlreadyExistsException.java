package com.example.cartservice.Exception;

public class ResourceAlreadyExistsException extends Exception {
	public ResourceAlreadyExistsException() {
		super();
	}

	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
