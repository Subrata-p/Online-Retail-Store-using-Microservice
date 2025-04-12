package com.wipro.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.config.dto.Productinv;
import com.wipro.config.model.Cart;
import com.wipro.config.model.Customer;
import com.wipro.config.model.CustomerCart;
import com.wipro.config.model.LineItem;
import com.wipro.config.model.Order;
import com.wipro.config.model.Product;
import com.wipro.config.model.exception.ResourceNotFoundException;
import com.wipro.config.model.service.ShoppingService;

@RestController
@RequestMapping("/api/shoppingservice")
public class ConsumerController {
@Autowired
ProductRestConsumer feignClient;
@Autowired
InventoryFeign invfign;

@Autowired
OrderFeign orderfign;

@Autowired
CustomerFeign customerfign;

@Autowired
ShoppingService shoppingService;

@Autowired
CartFeign cartfeign;

//@CircuitBreaker(name = "getInvoiceCB", fallbackMethod = "getInvoiceFallback")

//@CircuitBreaker(fallbackMethod="defaultGreeting", name = "GetServiceInfo")
@GetMapping("/data")
public String getProductInfo() {

   System.out.println(feignClient.getClass().getName());  //prints as a proxy class
   return "Accessing from PRODUCT-SERVICE ==> " +feignClient.getProductsData();
}

@PostMapping("/product")
public Product addProduct(@RequestBody Product prod)
{
	return feignClient.addProduct(prod);
}

/*
@PostMapping("/order")  
public ResponseEntity<Order> saveOrder(@RequestBody Order order){
	
	return orderfign.saveOrder(order);
}*/
/*
@PostMapping("/cart")  
public ResponseEntity<Cart> saveCart(@RequestBody Cart cart){
	
	return cartfeign.saveCart(cart);
}

@PostMapping("/customer")
public ResponseEntity<?> addcustomer(@RequestBody Customer c){
	
	return customerfign.addcustomer(c);
}*/

@GetMapping("/all")
public List<Product> GetServiceInfo() {

   return  feignClient.findAllProducts();
}

@GetMapping("/searchCustomer")
public ResponseEntity<?> searchCustomer(){
	
	 return  customerfign.searchCustomer();
}


@GetMapping("/product/{id}")
public Product getProduct(@PathVariable Integer id) {
   return feignClient.getProduct(id); 
   //call another service
}
/*
public String defaultGreeting(RuntimeException e) {
	return "Hello this is a default greeting Message Fall Back method (Static Data) !!!";
    
}
*/
/*

public List<Product> defaultMethodforAllrequest(RuntimeException e) {
	System.out.println("Test in list default");
	return null;
   
}
*/ 
/*
@PostMapping("/addProduct")
public ResponseEntity<String> addInventory(@RequestBody Productinv proddetails)
{
	Product prod = new Product();
	Inventory inv = new Inventory();
	prod.setId(proddetails.getId());
	prod.setName(proddetails.getName());
	prod.setDiscription(proddetails.getDiscription());
	prod.setPrice(proddetails.getPrice());
	int  prodId=feignClient.addProduct(prod).getId();
	Inventory invent = new Inventory();
	invent.setProductId(prodId);
	invent.setQuantity(proddetails.getQuantity());
	int invid=invfign.addInventory(invent);
	ResponseEntity<String> respon;
	if(invid > 0)
	{
		respon= new ResponseEntity<String>("Succesfully created",HttpStatus.CREATED);
	}
	else
		respon= new ResponseEntity<String>("Some exception",HttpStatus.BAD_REQUEST);
	
	return respon;
}

@PostMapping("/addCustomer")
public ResponseEntity<Order> saveOrder(@RequestBody CustomerOrder proddetails1)
{
	Customer prod1 = new Customer();
	Order invent1 = new Order();
	LineItem prod2 = new LineItem();
	prod1.setCustomerEmail(proddetails1.getCustomerEmail());
	prod1.setCustomerId(proddetails1.getCustomerId());
	prod1.setCustomerName(proddetails1.getCustomerName());
	prod1.setCity(proddetails1.getCity());
	ResponseEntity<?> prodId1 = customerfign.addcustomer(prod1);
	invent1.setOrderId(proddetails1.getOrderId());
	ResponseEntity<Order> invid2=orderfign.saveOrder(invent1);
	return invid2;
}*/


@PostMapping("/products")
public ResponseEntity<String> createProduct(@RequestBody Productinv productQuantityDto){
	return ResponseEntity.status(HttpStatus.CREATED).body(shoppingService.createProduct(productQuantityDto));
}

@PostMapping("/customer")
public ResponseEntity<CustomerCart> addCustomer(@RequestBody Customer customer){
	return ResponseEntity.status(HttpStatus.CREATED).body(shoppingService.addCustomer(customer));
}
@PostMapping("/customer/{customerId}/order")
public ResponseEntity<Order> createOrder(@PathVariable("customerId") int customerId)throws ResourceNotFoundException {
	return ResponseEntity.status(HttpStatus.OK).body(shoppingService.createOrder(customerId));
}

@PutMapping("/customer/{customerId}/cart")
public ResponseEntity<Cart> addItemsToCart(@RequestBody Cart cart, @PathVariable("customerId") int customerId)throws ResourceNotFoundException {
	return ResponseEntity.status(HttpStatus.OK).body(shoppingService.addItemsToCart(cart, customerId));
}

@GetMapping("/customer/{customerId}/orders")
public ResponseEntity<List<Order>> getAllOrders(@PathVariable("customerId") int customerId)throws ResourceNotFoundException {
	return ResponseEntity.status(HttpStatus.OK).body(shoppingService.getAllOrders(customerId));
}
}

