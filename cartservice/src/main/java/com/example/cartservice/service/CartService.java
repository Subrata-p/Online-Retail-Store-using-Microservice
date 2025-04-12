package com.example.cartservice.service;

import org.springframework.stereotype.Service;

import com.example.cartservice.Exception.ResourceAlreadyExistsException;
import com.example.cartservice.Exception.ResourceNotFoundException;
import com.example.cartservice.model.Cart;

@Service
public interface CartService {
	public Cart addCart(Cart cart) throws ResourceAlreadyExistsException;

	public Cart searchCart(int cartId) throws ResourceNotFoundException;

	public Cart updateCart(Cart cart) throws ResourceNotFoundException;

	public void emptyCart(int cartId) throws ResourceNotFoundException;

}
