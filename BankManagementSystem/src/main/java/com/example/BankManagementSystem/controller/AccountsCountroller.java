package com.example.BankManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.model.Account;
import com.example.BankManagementSystem.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountsCountroller {

	 private final AccountService accountService;

	public AccountsCountroller(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	 
	
	@PostMapping
	public Account createAccount(@RequestBody Account account)
	{
		return accountService.createAccount(account);
	}
	 
    @GetMapping("/{id}")
    public Account getAccountDetails(@PathVariable Long id)
    {
    	return accountService.getAccountDetails(id);
    }
    
}
