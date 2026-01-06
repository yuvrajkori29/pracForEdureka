package com.example.BankManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.model.Customer;
import com.example.BankManagementSystem.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController{
	 
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id)
	{
		return customerService.getCustomer(id);
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	
}