package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepo;

@Service
public class customerService {
	@Autowired
	CustomerRepo crepo;
	public Customer addcustomer(Customer cust) {
		return crepo.save(cust);
	}
	public List<Customer> listcustomers(){
		return crepo.findAll();
	}
	
	public String deleteCustomer(int customerId) {
		 Optional op=crepo.findById(customerId);
		 Customer cust;
		 if(op.isPresent()) {
		 cust=(Customer) op.get();
		 crepo.deleteById(customerId);
		 return "data deleted";
	}
	else {
		return "no data found";
	}
		 
		
	}
		 public Customer getCustomerById(int cId) {
			Optional op=crepo.findById(cId);
			if(op.isPresent()) {
				return (Customer) op.get();
			}
			else {
				return null;
			}
			

}
		 public Optional<Customer> updateCustomer(Customer request, int custno)
			{
				Optional<Customer> customer = crepo.findById(custno);
				customer.map(cust -> {
					
					cust.setCustomerName(request.getCustomerName());
					cust.setCustomerEmail(request.getCustomerEmail());
			        cust.setCustomerBillingAddress(request.getCustomerBillingAddress());
			        cust.setCustomerShippingAddress(request.getCustomerShippingAddress());
					return crepo.save(cust);
				});
				return customer;
			}
		
		
			
		 
			
}
