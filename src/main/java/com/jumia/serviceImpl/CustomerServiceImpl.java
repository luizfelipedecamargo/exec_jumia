package com.jumia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.entities.Customer;
import com.jumia.repositories.CustomerRepository;
import com.jumia.service.CustomerService;

@Service
public class CustomerServiceImpl  implements CustomerService{

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}	
	
	@Override
	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(long customerId) {
		return customerRepository.findCustomerById(customerId);
	}	
	
	@Override
	public Customer findCustomerByName(String customerName) {
		return customerRepository.findCustomerByName(customerName);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);	
	}

	@Override
	public void updCustomer(Customer customer) {
		
		Customer updatedCustomer = customerRepository.findCustomerById(customer.getCustomerId());		
		
		updatedCustomer.setCustomerName(customer.getCustomerName());
		updatedCustomer.setCustomerPhone(customer.getCustomerPhone());
		customerRepository.save(updatedCustomer);
		
	}

	@Override
	public void delCustomer(long customerId) {		
		customerRepository.deleteById(customerId);
		
	}

}
