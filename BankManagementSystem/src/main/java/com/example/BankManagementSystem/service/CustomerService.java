package com.example.BankManagementSystem.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.model.Customer;
import com.example.BankManagementSystem.repository.CustomerRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService{
	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	
	//method calls
	
	
	
	public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
	
	
	@Cacheable(key = "#id",value = "customers")
	public Customer getCustomer(Long id) {
	    return customerRepository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
	}
    
    
    
}