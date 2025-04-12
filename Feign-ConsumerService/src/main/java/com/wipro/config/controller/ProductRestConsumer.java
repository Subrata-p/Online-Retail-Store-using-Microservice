package com.wipro.config.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.wipro.config.model.Product;

@FeignClient(value="PRODUCT",url="http://localhost:1000/api")
public interface ProductRestConsumer {
	@GetMapping("product/data")
    public String getProductsData();
	
	@PostMapping("addProduct")
	    public Product addProduct(@RequestBody Product prod);
		
	 @GetMapping("product/{id}")
	    public Product getProduct(@PathVariable int id);
	 
	// @GetMapping("product/all")
	 //public List<Product> getAllProducts();
	 
	
	 @GetMapping("/order")
	 public List<Product> findAllProducts();
		
}
