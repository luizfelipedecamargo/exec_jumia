package com.jumia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jumia.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	@Query(value = "SELECT c FROM Customer c WHERE UPPER(c.customerName) = UPPER(:customerName)")
	Customer findCustomerByName(@Param("customerName") String customerName);	
	
	@Query(value = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
	Customer findCustomerById(@Param("customerId") long customerId);
	
}


