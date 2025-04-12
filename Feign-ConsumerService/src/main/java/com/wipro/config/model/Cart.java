package com.wipro.config.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {

	
	 private int cartId;
	 private List<LineItem> items;
	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public List<LineItem> getItems() {
		return items;
	}



	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	



	public Cart(int cartId, List<com.wipro.config.model.LineItem> items) {
		super();
		this.cartId = cartId;
		this.items = items;
	}



	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
}
