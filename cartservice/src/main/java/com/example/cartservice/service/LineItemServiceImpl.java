package com.example.cartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cartservice.Exception.ResourceAlreadyExistsException;
import com.example.cartservice.Exception.ResourceNotFoundException;
import com.example.cartservice.model.LineItem;
import com.example.cartservice.repository.LineItemRepository;

@Service
public class LineItemServiceImpl implements LineItemService {
	@Autowired
	private LineItemRepository lineItemRepository;

	@Override
	public LineItem addLineItem(LineItem lineItem) throws ResourceAlreadyExistsException {
		if (lineItemRepository.findById(lineItem.getId()).isPresent()) {
			throw new ResourceAlreadyExistsException("Line Item with this ID already exists");
		}

		return lineItemRepository.save(lineItem);
	}

	@Override
	public void deleteLineItem(int id) throws ResourceNotFoundException {
		lineItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("LineItem with this ID doesn't exist"));

		lineItemRepository.deleteById(id);

	}

	@Override
	public LineItem updateLineItem(LineItem lineItem) throws ResourceNotFoundException {
		lineItemRepository.findById(lineItem.getId())
				.orElseThrow(() -> new ResourceNotFoundException("LineItem with this ID doesn't exist"));
		return lineItemRepository.save(lineItem);
	}

	@Override
	public LineItem searchLineItem(int id) throws ResourceNotFoundException {
		lineItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("LineItem with this ID doesn't exist"));

		return lineItemRepository.findById(id).get();
	}

}
