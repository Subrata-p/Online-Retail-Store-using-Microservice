package com.example.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Globalexceptionhandler {
	@ExceptionHandler(DataNotFound.class)
	public ResponseEntity<?> handlenodataexception(DataNotFound err){
		return new ResponseEntity<>(err.getMessage(),HttpStatus.BAD_REQUEST);
		
}
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<?> handlenodataexception(CustomerNotFound err){
		return new ResponseEntity<>(err.getMessage(),HttpStatus.BAD_REQUEST);
		
}
	
}