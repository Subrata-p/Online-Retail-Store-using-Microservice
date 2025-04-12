package com.example.demo.exceptions;

public class CustomerNotFound extends Exception {
	String message;
	public CustomerNotFound (String message) {
		super(message);
	}

}
