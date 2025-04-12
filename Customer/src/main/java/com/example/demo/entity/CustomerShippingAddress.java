package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerShippingAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sId;
	private long doorNo;
	private String streetName;
	private String layout;
	private String city;
	private long pincode;
	
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

}
