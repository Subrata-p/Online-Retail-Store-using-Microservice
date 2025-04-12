package com.example.cartservice.service;

import org.springframework.stereotype.Service;


import com.example.cartservice.Exception.ResourceAlreadyExistsException;
import com.example.cartservice.Exception.ResourceNotFoundException;
import com.example.cartservice.model.LineItem;

@Service
public interface LineItemService {
	public LineItem addLineItem(LineItem lineItem) throws ResourceAlreadyExistsException;

	public void deleteLineItem(int id) throws ResourceNotFoundException;

	public LineItem updateLineItem(LineItem lineItem) throws ResourceNotFoundException;

	public LineItem searchLineItem(int id) throws ResourceNotFoundException;

}
