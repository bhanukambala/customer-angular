package com.dxctraining.customer.util;

import org.springframework.stereotype.Component;

import com.dxctraining.customer.dto.CustomerDto;
import com.dxctraining.customer.entities.Customer;

@Component
public class ConsumerUtil {
	public CustomerDto consumerDto(Customer consumer) {
		CustomerDto dto = new CustomerDto(consumer.getId(), consumer.getName());
		return dto;
	}
}
