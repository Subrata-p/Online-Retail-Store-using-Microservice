package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerBillingAddress {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)
private int bId;
	private long doorNo;
	private String streetName;
	private String layout;
	private String city;
	private long pincode;
		public int getbId() {
		return bId;
	}
	public void setCbId(int bId) {
		this.bId = bId;
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
