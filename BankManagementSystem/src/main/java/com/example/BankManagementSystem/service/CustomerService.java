package com.example.BankManagementSystem.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.BankManagementSystem.model.Account;
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
    
	//put request 
	
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer)
	{
		Customer customer2 = customerRepository.findById(id).orElse(null);
		
		customer2.setEmail(customer.getEmail());
		customer2.setName(customer.getName());
		customer2.setPhone(customer.getPhone());
		customer2.setAccounts(customer.getAccounts());
		
		customerRepository.save(customer2);
		
		return customer2;
		
	}
    
	
	//delete request
	public void deleteCustomer( Long id)
	{
         customerRepository.deleteById(id);
		
	}
	
	//get all accounts for a customer
	//get  method for all accounts for a customer
    public List<Account> listAccountsForCustomer( Long id)
    {   
    	Customer customer = customerRepository.findById(id).orElse(null);
        List<Account> listofAllAccountForCustomer = customer.getAccounts();
        return listofAllAccountForCustomer;
    }
    
    
    
}