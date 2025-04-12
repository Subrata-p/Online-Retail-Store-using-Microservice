package com.wipro.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.wipro.config.model.CustomerCart;

public interface CustomerCartRepository extends JpaRepository<CustomerCart, Integer>{
	public Optional<CustomerCart> findByCustomerId(int customerId);
}
