package com.wipro.config.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CustomerCart {
	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private int cartId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public CustomerCart(int id, int customerId, int cartId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.cartId = cartId;
	}
	public CustomerCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
