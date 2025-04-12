package com.example.cartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cartservice.model.LineItem;

public interface LineItemRepository extends CrudRepository<LineItem, Integer>{

}
