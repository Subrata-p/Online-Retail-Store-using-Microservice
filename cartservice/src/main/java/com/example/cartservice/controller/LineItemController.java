package com.example.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cartservice.Exception.ResourceAlreadyExistsException;
import com.example.cartservice.Exception.ResourceNotFoundException;
import com.example.cartservice.model.LineItem;
import com.example.cartservice.service.LineItemService;

@RestController
@RequestMapping("/api/cart/item")
public class LineItemController {
	@Autowired
	LineItemService lineItemService;

	@PostMapping
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem lineItem) throws ResourceAlreadyExistsException {
		return new ResponseEntity<LineItem>(lineItemService.addLineItem(lineItem), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLineItem(@PathVariable int id) throws ResourceNotFoundException {
		lineItemService.deleteLineItem(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LineItem> updateLineItem(@RequestBody LineItem lineItem, @PathVariable int id)
			throws ResourceNotFoundException {
		return new ResponseEntity<LineItem>(lineItemService.updateLineItem(lineItem), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LineItem> searchLineItem(int id) throws ResourceNotFoundException {
		return new ResponseEntity<LineItem>(lineItemService.searchLineItem(id), HttpStatus.OK);
	}

}
