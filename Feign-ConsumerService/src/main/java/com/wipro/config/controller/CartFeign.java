package com.wipro.config.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.config.model.Cart;

@FeignClient(value="cart",url="http://localhost:1085")
public interface CartFeign {

	@PostMapping("/api/cart/")
	public Cart addCart(@RequestBody Cart cart);
	
	@GetMapping("/api/cart/{id}")
	public Cart searchCart(@PathVariable int id);

	@PutMapping("/api/cart/{id}")
	public Cart updateCart(@PathVariable int id, @RequestBody Cart cart);
	
	@DeleteMapping("/api/cart/{id}")
	public String emptyCart(@PathVariable int id);

	
	
}
