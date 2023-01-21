package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerNotFound;
import com.masai.model.Customer;
import com.masai.service.CustomerService;


@RestController
public class CustomerController {
 
	@Autowired
	private CustomerService CS;
	
	@PostMapping("/AddCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)throws CustomerNotFound{
		
		Customer AddedCustomer=CS.addCustomer(customer);
		
		return new ResponseEntity<Customer>(AddedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer)throws CustomerNotFound{
		
		Customer updatedCustomer=CS.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeCustomer/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Integer customerId)throws CustomerNotFound{
		
		System.out.println(customerId+"==========================");
		
		Customer removedCustomer=CS.removeCustomer(customerId);
		
		return new ResponseEntity<Customer>(removedCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/viewCustomer/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") Integer customerId)throws CustomerNotFound{
		
		Customer Customer=CS.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(Customer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewAllCustomer")
	public ResponseEntity<List<Customer>> viewAllCustomerHandler() throws CustomerNotFound{
		
		List<Customer> customers = CS.viewAllCustomer();
		
		return new ResponseEntity<>(customers,HttpStatus.OK);
		
	}
	
	
}
