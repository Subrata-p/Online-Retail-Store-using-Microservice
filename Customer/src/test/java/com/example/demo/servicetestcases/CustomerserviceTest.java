package com.example.demo.servicetestcases;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Service.customerService;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerBillingAddress;
import com.example.demo.entity.CustomerShippingAddress;
import com.example.demo.repository.CustomerRepo;

@ExtendWith(SpringExtension.class)
public class CustomerserviceTest {
	@InjectMocks 
	customerService cservice;
	@Mock
	CustomerRepo crepo;
	@Test
	public void getcustomerById() {
		cservice.getCustomerById(2);
		asserThat(crepo.findById(2).isEmpty());
	}
	private void asserThat(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Order(1)
	@Test
	public void addcustomertest() {
		Customer cust=new Customer();
		cust=new Customer();
		cust.setCustomerId(1);
		cust.setCustomerName("manish");
		cust.setCustomerEmail("bmanish@gmail.com");
	CustomerBillingAddress cbaddress=new CustomerBillingAddress();
	cbaddress=(CustomerBillingAddress) new CustomerBillingAddress();
	cbaddress.setCbId(1);
	cbaddress.setCity("hyd");
	cbaddress.setDoorNo(2);
	cbaddress.setLayout("bvc");
	cbaddress.setStreetName("vb");
	cbaddress.setPincode(50105);
	CustomerShippingAddress csaddress=new CustomerShippingAddress();
	csaddress=(CustomerShippingAddress) new CustomerShippingAddress();
	csaddress.setsId(1);
	csaddress.setCity("hyd");
	csaddress.setDoorNo(2);
	csaddress.setLayout("bvc");
	csaddress.setStreetName("vb");
	csaddress.setPincode(50105);
	crepo.save(cust);
	when(crepo.save(any())).thenReturn(cust);
	Customer c= cservice.addcustomer(cust);
	assertEquals(cust,c);
	
		
	}

}
