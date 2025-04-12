package com.wipro.config.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LineItem {
	
	

 private int id;
 private int productId;
 private String productName;
 private int quantity;
 private int price;

public int getItemId() {
	return id;
}
public void setItemId(int itemId) {
	this.id = itemId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public LineItem(int itemId, int productId, String productName, int quantity, int price) {
	super();
	this.id = itemId;
	this.productId = productId;
	this.productName = productName;
	this.quantity = quantity;
	this.price = price;
}
public LineItem() {
	super();
	// TODO Auto-generated constructor stub
}

 
 

}
