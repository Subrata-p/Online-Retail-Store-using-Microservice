package com.wipro.config.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Productinv {
	
	private int id;
    private String name;
    private int quantity;
    private String discription;
    private double price;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Productinv(int id, String name, int quantity, String discription, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.discription = discription;
		this.price = price;
	}
	public Productinv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
}
