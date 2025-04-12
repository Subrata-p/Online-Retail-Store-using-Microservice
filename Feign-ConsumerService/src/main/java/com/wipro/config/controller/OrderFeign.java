package com.wipro.config.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.config.model.Cart;
import com.wipro.config.model.Order;


@FeignClient(value="order",url="http://localhost:1023")
public interface OrderFeign {
	
	@PostMapping("/api/order")  
	public Order saveOrder(@RequestBody Order order); 
	
	@DeleteMapping("/api/order/{itemId}")  
	public String deleteCustomer(@PathVariable("itemId") int itemId);
	
	@GetMapping("/api/item/{itemId}")
	public Order getCustomerById(@PathVariable("itemId") int itemId);
	
	
}
