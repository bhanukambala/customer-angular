package com.dxctraining.customer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.customer.dao.ICustomerDao;
import com.dxctraining.customer.entities.Customer;
import com.dxctraining.customer.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao dao;
	
	@Override
	public Customer findById(Integer id) {
		Optional<Customer> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new CustomerNotFoundException("consumer not found for id= " + id);
		}
		Customer consumer= optional.get();
		return consumer;	}

	@Override
	public List<Customer> findByName(String name) {
		List<Customer> list = dao.findByName(name);
		return list;
	}

	@Override
	public Customer add(Customer consumer) {
		consumer = dao.save(consumer);
		return consumer;
	}

}
