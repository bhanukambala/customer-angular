package com.dxctraining.customer.service;

import java.util.List;

import com.dxctraining.customer.entities.Customer;

public interface ICustomerService {
	Customer findById(Integer id);
	List<Customer> findByName(String name);
	Customer add(Customer consumer);
	
}
