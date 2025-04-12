package com.wipro.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.config.model.CustomerOrder;


public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
	public List<CustomerOrder> findAllByCustomerId(int customerId);
}
