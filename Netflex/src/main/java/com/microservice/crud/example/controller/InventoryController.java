package com.microservice.crud.example.controller;

import com.microservice.crud.example.entity.Inventory;
import com.microservice.crud.example.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/addInventory")
    public Inventory addInventory(@RequestBody Inventory product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addInventories")
    public List<Inventory> addProducts(@RequestBody List<Inventory> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/Inventories")
    public List<Inventory> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/InventoryById/{inventoryId}")
    public Inventory findProductById(@PathVariable int inventoryId) {
        return service.getProductById(inventoryId);
    }

   
    @PutMapping("/update")
    public Inventory updateProduct(@RequestBody Inventory product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{inventoryId}")
    public String deleteProduct(@PathVariable int inventoryId) {
        return service.deleteProduct(inventoryId);
    }
}
