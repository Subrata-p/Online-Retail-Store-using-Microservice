package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.CustomerBillingAddress;
import com.example.demo.repository.CustomerBillingAddressRepo;

@Service
public class CustomerBillingAddressService {
	@Autowired
	CustomerBillingAddressRepo cbrepo;
	
	public CustomerBillingAddress addcustomerbillingadd(CustomerBillingAddress cust) {
		return cbrepo.save(cust);
	}

}
