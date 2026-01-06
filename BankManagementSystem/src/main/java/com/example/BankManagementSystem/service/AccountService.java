package com.example.BankManagementSystem.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.model.Account;
import com.example.BankManagementSystem.repository.AccountRepository;

@Service
public class AccountService {
    
	private final AccountRepository accountRepository;
	
	 
	
	//methods to call services 
    public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Cacheable(value = "accounts", key = "#id")
    public Account getAccountDetails(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }
}
