package com.microservice.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.crud.example.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
   
}
