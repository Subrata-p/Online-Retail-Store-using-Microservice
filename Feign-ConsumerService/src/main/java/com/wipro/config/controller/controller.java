package com.wipro.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class controller {
	@Value("${user.role}")
	String role;
	@Value("${message}")
	String message;
	
	
	
	
	@GetMapping("/message")
	public String getMessage()
	{
		return "hi You are a "+role+" "+message;
	}
	
	
	

}
