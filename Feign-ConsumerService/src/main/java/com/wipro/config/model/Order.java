package com.wipro.config.model;



import java.util.ArrayList;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
public class Order {
	
	 
	 private int orderId;
	 private List<LineItem> lineitem;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<LineItem> getLineitem() {
		return lineitem;
	}

	public void setLineitem(List<LineItem> lineitem) {
		this.lineitem = lineitem;
	}

	public Order(int orderId, List<LineItem> lineitem) {
		super();
		this.orderId = orderId;
		this.lineitem = lineitem;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
