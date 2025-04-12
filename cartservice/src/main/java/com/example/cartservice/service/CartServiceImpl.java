package com.example.cartservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cartservice.Exception.ResourceAlreadyExistsException;
import com.example.cartservice.Exception.ResourceNotFoundException;
import com.example.cartservice.model.Cart;
import com.example.cartservice.model.LineItem;
import com.example.cartservice.repository.CartRepository;
import com.example.cartservice.repository.LineItemRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private LineItemRepository lineItemRepository;

	@Override
	public Cart addCart(Cart cart) throws ResourceAlreadyExistsException {

		if (cartRepository.findById(cart.getCartId()).isPresent()) {
			throw new ResourceAlreadyExistsException("Cart with this ID already exists");
		}

		Cart savedCart = cartRepository.save(cart);

		List<LineItem> items = savedCart.getItems().stream().map(item -> {
			item.setCart(savedCart);
			return item;
		}).collect(Collectors.toList());

		lineItemRepository.saveAll(items);

		return savedCart;

	}

	@Override
	public void emptyCart(int cartId) throws ResourceNotFoundException {
		Cart existingCart = cartRepository.findById(cartId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart with this ID doesn't exist"));
		existingCart.setItems(new ArrayList<>());
		
		cartRepository.save(existingCart);

	}

	@Override
	public Cart updateCart(Cart cart) throws ResourceNotFoundException {
		Cart existingCart = cartRepository.findById(cart.getCartId())
				.orElseThrow(() -> new ResourceNotFoundException("Cart with this ID doesn't exist"));
		List<LineItem> existingLineItems = existingCart.getItems();
		List<LineItem> newLineItems = cart.getItems();

		List<LineItem> updatedLineItems = new ArrayList<>();
		existingCart.setItems(
				Stream.concat(existingLineItems.stream(), newLineItems.stream()).collect(Collectors.toList()));
		;
		for (LineItem lineItem : newLineItems) {
			lineItem.setCart(existingCart);
			updatedLineItems.add(lineItem);
		}

		return cartRepository.save(existingCart);
	}

	@Override
	public Cart searchCart(int cartId) throws ResourceNotFoundException {

		Optional<Cart> optional = cartRepository.findById(cartId);
		if (optional.isPresent()) {
			return optional.get();
		}

		throw new ResourceNotFoundException("Cart with this ID doesn't exist");

	}

}
