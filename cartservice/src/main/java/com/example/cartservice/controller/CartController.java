package com.example.cartservice.controller;

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

import com.example.cartservice.Exception.ResourceAlreadyExistsException;
import com.example.cartservice.Exception.ResourceNotFoundException;
import com.example.cartservice.model.Cart;
import com.example.cartservice.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping({ "", "/" })
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws ResourceAlreadyExistsException {
		return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> searchCart(@PathVariable int id) throws ResourceNotFoundException {
		// Cart seaCart = cartService.searchCart(cartId);
		return new ResponseEntity<Cart>(cartService.searchCart(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable int id, @RequestBody Cart cart)
			throws ResourceNotFoundException {
		// List<Cart> updated = cartService.updateCart(cart);
		return new ResponseEntity<Cart>(cartService.updateCart(cart), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> emptyCart(@PathVariable int id) throws ResourceNotFoundException {
		cartService.emptyCart(id);
		return new ResponseEntity<String>("Items deleted", HttpStatus.OK);
	}

}
