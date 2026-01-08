package com.example.BankManagementSystem.service;



import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.example.BankManagementSystem.model.Account;
import com.example.BankManagementSystem.model.Customer;
import com.example.BankManagementSystem.repository.AccountRepository;
import com.example.BankManagementSystem.repository.CustomerRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional // Ensures database integrity
public class AccountService {
    
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;


    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
      
    }

    public Account createAccount(Account account) {
      
        Customer existingCustomer = customerRepository.findById(account.getCustomer().getId())
            .orElseThrow(() -> new RuntimeException("Customer ID " + account.getCustomer().getId() + " not found"));
        
        account.setCustomer(existingCustomer);
        
       
        return accountRepository.save(account);
    }

    @Cacheable(value = "accounts", key = "#id")
    public Account getAccountDetails(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account updateAccountStatus(Long id, Account incomingAccount) {
        Account existingAccount = accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found"));
        
        existingAccount.setBalance(incomingAccount.getBalance());
        

        if (incomingAccount.getCustomer() != null) {
            Customer customer = customerRepository.findById(incomingAccount.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
            existingAccount.setCustomer(customer);
        }

        return accountRepository.save(existingAccount);
    }
    
    public List<Account> getAccountsById(Long id)

    {

    return accountRepository.findByCustomerId(id);

    }
}
