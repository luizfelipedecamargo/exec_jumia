package com.jumia.service;

import org.springframework.stereotype.Service;

import com.jumia.entities.Customer;

@Service
public interface CustomerService {

	public Iterable<Customer> findAllCustomers();
	public Customer findCustomerById(long customerId);
	public Customer findCustomerByName(String customerName); 
	public void addCustomer(Customer customer);
	public void updCustomer(Customer customer);
	public void delCustomer(long customerId);
	
}
