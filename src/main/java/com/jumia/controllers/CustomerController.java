package com.jumia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.entities.Customer;
import com.jumia.exception.JumiaException;
import com.jumia.service.CustomerService;
import com.jumia.util.Util;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public @ResponseBody Iterable<Customer> customersFindAll() {
		return customerService.findAllCustomers();
	}	

	@RequestMapping(value = "/exist/{customerName}", method = RequestMethod.GET)
	public ResponseEntity<?> findCustomerByName(@PathVariable("customerName") String customerName) {

		Customer customer = customerService.findCustomerByName(customerName); 

		if (Util.isEmpty(customer)) {
			return new ResponseEntity<JumiaException>(new JumiaException(customerName + ": Customer Not Found "), HttpStatus.NOT_FOUND); 	
		} 

		return new ResponseEntity<Customer>(customer, HttpStatus.OK); 
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customerBody){

		if (!Util.isEmpty(customerService.findCustomerById(customerBody.getCustomerId()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Customer Id Duplicated: Customer " + customerBody.getCustomerId() + " already exist."), HttpStatus.CONFLICT); 	
		}
		
		if (!Util.isValid(customerBody.getCustomerPhone(), customerBody.getCountryId())) {
			return new ResponseEntity<JumiaException>(new JumiaException("Customer Phone Number " + customerBody.getCustomerPhone() + " Is Not Valid for Country Id " + customerBody.getCountryId()), HttpStatus.CONFLICT);
		}
		
		customerService.addCustomer(customerBody);

		return new ResponseEntity<Customer>(customerBody, HttpStatus.CREATED); 

	}

	@RequestMapping(value = "/upd", method = RequestMethod.PUT)
	public ResponseEntity<?> updCustomer(@Valid @RequestBody Customer customerBody){

		if (Util.isEmpty(customerService.findCustomerById(customerBody.getCustomerId()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Customer Update Error: Customer Id " + customerBody.getCustomerId() + " Do Not Exist."), HttpStatus.NOT_FOUND); 	
		}
		
		if (!Util.isValid(customerBody.getCustomerPhone(), customerBody.getCountryId())) {
			return new ResponseEntity<JumiaException>(new JumiaException("Customer Phone Number " + customerBody.getCustomerPhone() + " Is Not Valid for Country Id " + customerBody.getCountryId()), HttpStatus.CONFLICT);
		}		
		
		customerService.updCustomer(customerBody);

		return new ResponseEntity<Customer>(customerBody, HttpStatus.OK);		

	}
	
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ResponseEntity<?> delCustomer(@Valid @RequestBody Customer customerBody){
		
		if (Util.isEmpty(customerService.findCustomerById(customerBody.getCustomerId()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Customer Delete Error: Customer Id " + customerBody.getCustomerId() + " Do Not Exist."), HttpStatus.NOT_FOUND); 	
		}	
		
		customerService.delCustomer(customerBody.getCustomerId());
		
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		
	}


}
