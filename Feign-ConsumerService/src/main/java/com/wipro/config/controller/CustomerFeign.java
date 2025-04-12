package com.wipro.config.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.config.model.Customer;

@FeignClient(value="customer",url="http://localhost:1999/api")
public interface CustomerFeign {
	
	@PostMapping("/addCustomer")
	public Customer addcustomer(@RequestBody Customer c);
	
	@GetMapping("/searchCustomer")
	public ResponseEntity<?> searchCustomer();

}
