package com.wipro.config.model;

import java.util.ArrayList;
import java.util.List;




public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String city;
	private List<CustomerShippingAddress> customerShippingAddress = new ArrayList<>();
	private List<CustomerBillingAddress> customerBillingAddress = new ArrayList<>();
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<CustomerBillingAddress> getCustomerBillingAddress() {
		return customerBillingAddress;
	}
	public void setCustomerBillingAddress(List<CustomerBillingAddress> customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}
	public List<CustomerShippingAddress> getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	public void setCustomerShippingAddress(List<CustomerShippingAddress> customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
