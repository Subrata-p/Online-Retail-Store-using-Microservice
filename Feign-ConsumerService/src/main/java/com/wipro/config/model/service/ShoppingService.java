package com.wipro.config.model.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import com.wipro.config.controller.CartFeign;
import com.wipro.config.controller.CustomerFeign;
import com.wipro.config.controller.InventoryFeign;
import com.wipro.config.controller.OrderFeign;
import com.wipro.config.controller.ProductRestConsumer;
import com.wipro.config.dto.Productinv;
import com.wipro.config.model.Cart;
import com.wipro.config.model.Customer;
import com.wipro.config.model.CustomerCart;
import com.wipro.config.model.CustomerOrder;
import com.wipro.config.model.Inventory;
import com.wipro.config.model.LineItem;
import com.wipro.config.model.Order;
import com.wipro.config.model.Product;
import com.wipro.config.model.exception.ResourceNotFoundException;
import com.wipro.config.repository.CustomerCartRepository;
import com.wipro.config.repository.CustomerOrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ShoppingService {
	
	@Autowired
	ProductRestConsumer feignClient;
	@Autowired
	InventoryFeign invfign;
	
	@Autowired
	CustomerFeign customerfign;
	
	@Autowired
	CartFeign cartfeign;
	
	@Autowired
	CustomerCartRepository customerCartRepository;
	
	@Autowired
	CustomerOrderRepository customerOrderRepository;
	
	@Autowired
	OrderFeign orderfign;


	
	@CircuitBreaker(fallbackMethod = "createProductFallback", name = "fallBackForCreateProduct")
	//@HystrixCommand(fallbackMethod = "createProductFallback",commandKey="product",groupKey="products")
	public String createProduct(Productinv productQuantityDto) {
		Product pro = new Product();
		pro.setName(productQuantityDto.getName());
		pro.setPrice(productQuantityDto.getPrice());
		pro.setDiscription(productQuantityDto.getDiscription());
		Product savedProduct = feignClient.addProduct(pro);

		Inventory inv = new Inventory();
	    inv.setInventoryId(savedProduct.getId());
	    inv.setProductId(savedProduct.getId());
	    inv.setQuantity(productQuantityDto.getQuantity());
		Inventory savedInventory = invfign.addInventory(inv);

		return "Product and Inventory updated successfully";
	}

	public String createProductFallback(Productinv productQuantityDto, RuntimeException exception) {
		return "Product or Inventory Service is currently down. Please try again sometime.";
	}
	
	
	@CircuitBreaker(fallbackMethod = "addCustomerFallback", name = "fallBackForAddCustomer")
	public CustomerCart addCustomer(Customer customer) {
		Customer savedCustomer = customerfign.addcustomer(customer);

		Cart cart = new Cart();
		List<LineItem> line= new ArrayList<>();
		//cart.setCartId(0);
		cart.setItems(line);
		Cart savedCart = cartfeign.addCart(cart);

		/*CustomerCart customerCart = CustomerCart.builder().customerId(savedCustomer.getId())
				.cartId(savedCart.getCartId()).build();*/
		CustomerCart customerCart = new CustomerCart();
		customerCart.setCustomerId(savedCustomer.getCustomerId());
		customerCart.setCartId(savedCart.getCartId());

		return customerCartRepository.save(customerCart);

	}

	public CustomerCart addCustomerFallback(Customer customer, RuntimeException exception) {
		CustomerCart defaultCustomerCart = new CustomerCart();
		defaultCustomerCart.setId(0);
		defaultCustomerCart.setCustomerId(0);
		defaultCustomerCart.setCartId(0);

		return defaultCustomerCart;
	}
	

	@CircuitBreaker(fallbackMethod = "createOrderFallback", name = "fallBackForCreateOrder")
	public Order createOrder(int customerId) throws ResourceNotFoundException {
		Optional<CustomerCart> customerCartOptional = customerCartRepository.findByCustomerId(customerId);
		if (!customerCartOptional.isPresent()) {
			throw new ResourceNotFoundException("Required value doesn't exist.");
		}
		int cartId = customerCartOptional.get().getCartId();

		Cart savedCart = cartfeign.searchCart(cartId);

		//Order order = Order.builder().items(new ArrayList<LineItem>(savedCart.getItems())).build();
		
		Order order =  new Order();
		order.setLineitem(savedCart.getItems());

		Order savedOrder = orderfign.saveOrder(order);

		//CustomerOrder customerOrder = new CustomerOrder.builder().customerId(customerId).orderId(savedOrder.getOrderId())
				//.build();
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerId(customerId);
		customerOrder.setOrderId(savedOrder.getOrderId());
		customerOrderRepository.save(customerOrder);

		orderfign.deleteCustomer(cartId);
		return savedOrder;

	}
	
	//
	public Order createOrderFallback(int customerId, RuntimeException exception) {
		Order order = new Order();
		order.setOrderId(0);
		LineItem defaultLineItem = new LineItem();
		defaultLineItem.setProductId(0);
		defaultLineItem.setProductName("Product 0");
		defaultLineItem.setQuantity(0);
		defaultLineItem.setPrice(0);
		
		List<LineItem> defaultLineItemList = new ArrayList<>();
		defaultLineItemList.add(defaultLineItem);
		
		order.setLineitem(defaultLineItemList);
		
		return order;
	
	}
	
	@CircuitBreaker(fallbackMethod = "addItemsToCartFallback", name = "fallBackForAddItemsToCart")
	public Cart addItemsToCart(Cart cart, int customerId) throws ResourceNotFoundException {
		Optional<CustomerCart> customerCartOptional = customerCartRepository.findByCustomerId(customerId);
		if (!customerCartOptional.isPresent()) {
			throw new ResourceNotFoundException("Required value doesn't exist.");
		}
		int cartId = customerCartOptional.get().getCartId();

		cart.setCartId(cartId);

		return cartfeign.updateCart(cartId, cart);
	}

	public Cart addItemsToCartFallback(Cart cart, int customerId, RuntimeException exception) {
		Cart defaultCart = new Cart();
		defaultCart.setCartId(0);
		//LineItem defaultLineItem =  LineItem.builder().productId(0).productName("Product 0").quantity(0).price(0)
		//		.build();
		
		LineItem defaultLineItem = new LineItem();
		defaultLineItem.setProductId(0);
		defaultLineItem.setProductName("Product 0");
		defaultLineItem.setQuantity(0);
		defaultLineItem.setPrice(0);

		List<LineItem> defaultLineItemList = new ArrayList<>();
		defaultLineItemList.add(defaultLineItem);
		defaultCart.setItems(defaultLineItemList);
		return defaultCart;
	}
	
	@CircuitBreaker(fallbackMethod = "getAllOrdersFallback", name = "fallBackForGetAllOrders")
	public List<Order> getAllOrders(int customerId) {
		List<CustomerOrder> customerOrders = customerOrderRepository.findAllByCustomerId(customerId);

		List<Order> orders = new ArrayList<>();

		customerOrders.stream().forEach(customerOrder -> {
			orders.add(orderfign.getCustomerById(customerOrder.getOrderId()));

		});
		return orders;
	}
	
	public List<Order> getAllOrdersFallback(int customerId, RuntimeException exception){
		//Order order = Order.builder().orderId(0).build();
		//LineItem defaultLineItem = LineItem.builder().productId(0).productName("Product 0").quantity(0).price(0)
				//.build();
		Order order =new  Order();
		 order.setOrderId(customerId);
		LineItem defaultLineItem = new LineItem();
		defaultLineItem.setProductId(0);
		defaultLineItem.setProductName("Product 0");
		defaultLineItem.setQuantity(0);
		defaultLineItem.setPrice(0);

		List<LineItem> defaultLineItemList = new ArrayList<>();
		defaultLineItemList.add(defaultLineItem);
		
		order.setLineitem(defaultLineItemList);
		
		List<Order> defaultOrderList = new ArrayList<>();
		defaultOrderList.add(order);
		
		return defaultOrderList;
	}
}