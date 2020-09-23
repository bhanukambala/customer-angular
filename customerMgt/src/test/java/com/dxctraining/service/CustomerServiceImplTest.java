package com.dxctraining.service;


import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.customer.entities.Customer;
import com.dxctraining.customer.exception.*;
import com.dxctraining.customer.service.CustomerServiceImpl;
import com.dxctraining.customer.service.ICustomerService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({ CustomerServiceImpl.class })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceImplTest {

	@Autowired
	private ICustomerService service;
	
	@Test
	public void testAdd_1() {
		String name = "bhanu";
		Customer customer = new Customer(name);
		customer = service.add(customer);
		Customer fetchedcustomer = service.findById(customer.getId());
		Assertions.assertEquals(customer.getId(),fetchedcustomer.getId());
		Assertions.assertEquals(name,fetchedcustomer.getName());
	}
	
	@Test
	public void testFindById_1() {
		Executable executable=()->service.findById(73);
		Assertions.assertThrows(CustomerNotFoundException.class, executable);
	}
	
	@Test
	public void testFindById_2() {
		String name = "mallika";
		Customer customer = new Customer(name);
		customer = service.add(customer);
		Customer fetchedcustomer = service.findById(customer.getId());
		Assertions.assertEquals(customer.getId(), fetchedcustomer.getId());
	}}