package com.capstone.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.capstone.Exception.ResourceNotFoundException;
import com.capstone.Model.LineItem;
import com.capstone.Model.Order;
import com.capstone.Service.OrderService;


@RestController
@RequestMapping("/api")

public class OrderController {
	
	@Autowired
	OrderService ser;
	
	@GetMapping("/order")
	public List<Order> getAllOrders() throws ResourceNotFoundException {
		List<Order>customerlist= ser.getAllOrders();
		if(customerlist.size()==0)
			throw new ResourceNotFoundException("no Customer");
	return customerlist;
	}
	
	@GetMapping("/LineItem")
	public List<LineItem> getAllItems() throws ResourceNotFoundException {
		List<LineItem>customerlist1= ser.getAllItems();
		if(customerlist1.size()==0)
			throw new ResourceNotFoundException("no LineItem");
	return customerlist1;
	}
	
	@GetMapping("/item/{itemId}")
	public Order getCustomerById(@PathVariable("itemId") int itemId)
	{
		return ser.getCustomerById(itemId);
	}
	
	@GetMapping("/order/{orderId}")
	public LineItem getItemById(@PathVariable("orderId") int orderId)
	{
		return ser.getItemById(orderId);
	}

	@DeleteMapping("/order/{itemId}")  
	private String deleteCustomer(@PathVariable("itemId") int itemId)   
	{  
		return ser.delete(itemId);  
	}  
	
	@DeleteMapping("/Item/{orderId}")  
	private String deleteItem(@PathVariable("orderId") int orderId)   
	{  
		return ser.deletes(orderId);  
	}
	
	@PostMapping("/order")  
	private ResponseEntity<Order> saveCustomer(@RequestBody Order order)   
	{  
		Order cus=ser.saveOrUpdate(order);
		return new ResponseEntity<Order>(cus,HttpStatus.CREATED);
	
    }
	
	@PutMapping("/order")  
	private Order updateCustomer(@RequestBody Order order)   
	{  
		return ser.update(order);	
    }
	
	@PostMapping("/List/{orderId}")
	public LineItem addlist(@RequestBody LineItem acc,@PathVariable int orderId) {
		LineItem item=this.ser.addlist(acc, orderId);
			return item;
	}
	
	@PutMapping("/List/{itemId}")
	public ResponseEntity<Object> updateList(@RequestBody LineItem acc,@PathVariable("itemId") int itemId){
		List<LineItem> al=ser.getAllItems();
		List<Integer> ail=new ArrayList<Integer>();
		for(int i=0;i<al.size();i++) {
			ail.add(al.get(i).getItemId());
		}
		if(ail.contains(itemId)) {
			ser.updateItemDetail(acc, itemId);
			return new ResponseEntity<Object>("Account Details Updated Successfully",HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
