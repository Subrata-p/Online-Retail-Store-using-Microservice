package com.example.cartservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cartservice.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{
	

}
