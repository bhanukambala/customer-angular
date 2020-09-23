package com.dxctraining.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.customer.entities.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer> {
	List<Customer> findByName(String name);
}
