package com.example.demo.exceptions;

public class DataNotFound extends Exception {
	String message;
	public DataNotFound(String message) {
		super(message);
	}
}
