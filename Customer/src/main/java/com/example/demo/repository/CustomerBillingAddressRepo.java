package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerBillingAddress;

public interface CustomerBillingAddressRepo extends JpaRepository<CustomerBillingAddress, Integer> {

}
