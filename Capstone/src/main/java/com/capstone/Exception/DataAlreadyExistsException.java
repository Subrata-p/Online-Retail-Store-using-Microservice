package com.capstone.Exception;

@SuppressWarnings("serial")
public class DataAlreadyExistsException extends RuntimeException {
	public DataAlreadyExistsException() {
		 super("Data Already Exists");
		 }
	 public DataAlreadyExistsException(String message) {
		 super(message);
		 }

}
