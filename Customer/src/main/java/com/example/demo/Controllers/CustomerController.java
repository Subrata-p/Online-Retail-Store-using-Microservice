package com.example.demo.Controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.customerService;
import com.example.demo.entity.Customer;
import com.example.demo.exceptions.DataNotFound;



@RestController
@RefreshScope
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	customerService cservice;
	
    
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addcustomer(@RequestBody Customer c){
		Customer cust = cservice.addcustomer(c);
		return  new ResponseEntity<>(cust,HttpStatus.OK);
	}
	@GetMapping("/searchCustomer")
	public ResponseEntity<?> searchCustomer() throws DataNotFound {
		List<Customer> cust=cservice.listcustomers();
		if(cust.isEmpty()) {
			throw  new DataNotFound("data not exist");
		}
			else 
				return new ResponseEntity<>(cust,HttpStatus.OK);
			}
			
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int customerId){
		String msg=cservice.deleteCustomer(customerId);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/searchCustomer/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") int customerId) throws DataNotFound{
		Customer cust=cservice.getCustomerById(customerId);
		if(cust!=null)
			return new ResponseEntity<>(cust,HttpStatus.OK);
		else
			throw new DataNotFound("id not exist");
	}
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int customerId) throws DataNotFound
	{
		Customer cust = cservice.updateCustomer(customer, customerId).orElseThrow(() -> new DataNotFound("Customer id " + customerId + " is not found"));
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	@GetMapping("/hello")
	public String hello()
{
	return "Welcome to API gateway MANISH GOUD BURRA";
}
	
	
	
			
		
	
}


