
package com.microservice.crud.example.service;

import com.microservice.crud.example.entity.Inventory;
import com.microservice.crud.example.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;

    public Inventory saveProduct(Inventory product) {
        return repository.save(product);
    }

    public List<Inventory> saveProducts(List<Inventory> products) {
        return repository.saveAll(products);
    }

    public List<Inventory> getProducts() {
        return repository.findAll();
    }

    public Inventory getProductById(int inventoryId) {
        return repository.findById(inventoryId).orElse(null);
    }



    public String deleteProduct(int inventoryId) {
        repository.deleteById(inventoryId);
        return "inventory removed !! " + inventoryId;
    }

    public Inventory updateProduct(Inventory product) {
        Inventory existingProduct = repository.findById(product.getProductId()).orElse(null);
        existingProduct.setProductId(product.getProductId());
        existingProduct.setQuantity(product.getQuantity());
        
        return repository.save(existingProduct);
    }


}