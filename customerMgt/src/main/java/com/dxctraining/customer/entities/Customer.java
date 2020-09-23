package com.dxctraining.customer.entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	public Customer(String name) {
		this.name=name;
	}
	public Customer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 @Override
	    public int hashCode() {
	        return id;
	    }

	  @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Customer that = (Customer) obj;
	        return id == that.id;
	    }
}
