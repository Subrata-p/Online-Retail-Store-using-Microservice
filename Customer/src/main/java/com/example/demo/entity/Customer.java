package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String customerEmail;
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
	
	@OneToMany(targetEntity = CustomerBillingAddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name="cb_id", referencedColumnName = "customerId")
	public List<CustomerBillingAddress> customerBillingAddress;
	@OneToMany(targetEntity = CustomerShippingAddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name="cs_id", referencedColumnName = "customerId")
	public List<CustomerShippingAddress> customerShippingAddress;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
