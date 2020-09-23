package com.dxctraining.customer.controllers;

import com.dxctraining.customer.dto.CustomerDto;
import com.dxctraining.customer.dto.CreateCustomerRequest;
import com.dxctraining.customer.entities.Customer;
import com.dxctraining.customer.service.ICustomerService;
import com.dxctraining.customer.util.ConsumerUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumers")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@Autowired
	private ConsumerUtil util;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto create(@RequestBody CreateCustomerRequest requestData) {
		Customer consumer = new Customer();
		consumer.setName(requestData.getName());
		consumer = service.add(consumer);
		CustomerDto response = util.consumerDto(consumer);
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDto findBy(@PathVariable("id") Integer id) {
		Customer consumer = service.findById(id);
		CustomerDto response = util.consumerDto(consumer);
		return response;
	}

}
