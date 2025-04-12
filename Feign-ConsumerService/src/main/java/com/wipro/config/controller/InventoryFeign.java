package com.wipro.config.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.config.model.Inventory;


@FeignClient(value="Inventory",url="http://localhost:8091/api")
public interface InventoryFeign {
	
	 @PostMapping("addInventory")
	 //public int addInventory(com.wipro.config.model.Inventory inv);
	 public Inventory addInventory(@RequestBody Inventory inventory);

}
