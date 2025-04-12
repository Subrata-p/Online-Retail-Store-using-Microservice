package com.wipro.config.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
public class CustomerOrder {
	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private int orderId;
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public CustomerOrder(int id, int customerId, int orderId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderId = orderId;
	}
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
