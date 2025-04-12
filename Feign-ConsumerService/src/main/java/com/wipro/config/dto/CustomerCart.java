package com.wipro.config.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wipro.config.model.CustomerBillingAddress;
import com.wipro.config.model.CustomerShippingAddress;
import com.wipro.config.model.LineItem;

@Component
public class CustomerCart {

	private int customerId;
	private String customerName;
	private String customerEmail;
	private List<CustomerShippingAddress> customerShippingAddress = new ArrayList<>();
	private List<CustomerBillingAddress> customerBillingAddress = new ArrayList<>();
	 private List<LineItem> lineitem = new ArrayList<>();
	private int cartId;
	private int bId;
	private int sId;
    public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public List<LineItem> getLineitem() {
		return lineitem;
	}
	public void setLineitem(List<LineItem> lineitem) {
		this.lineitem = lineitem;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public long getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(long doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	private long doorNo;
	private String streetName;
	private String layout;
	private String city;
	private long pincode;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public List<CustomerShippingAddress> getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	public void setCustomerShippingAddress(List<CustomerShippingAddress> customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	public List<CustomerBillingAddress> getCustomerBillingAddress() {
		return customerBillingAddress;
	}
	public void setCustomerBillingAddress(List<CustomerBillingAddress> customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

}
