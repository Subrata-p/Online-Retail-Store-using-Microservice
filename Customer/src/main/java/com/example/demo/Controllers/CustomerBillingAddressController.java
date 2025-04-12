package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CustomerBillingAddressService;

import com.example.demo.entity.CustomerBillingAddress;

@RestController
public class CustomerBillingAddressController {
	@Autowired CustomerBillingAddressService cbservice;
	@PostMapping("/api/addcustomerbillingaddress")
	public ResponseEntity<?> addcustomer(@RequestBody CustomerBillingAddress c){
		CustomerBillingAddress cust = cbservice.addcustomerbillingadd(null);
		return  new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	
	@Value("${message: default message }")
    private String message;
	
	
	@GetMapping("/message")
	public String getMessage()
	{
		return message;
	}


}
