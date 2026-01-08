package com.example.BankManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.model.Account;
import com.example.BankManagementSystem.model.Transaction;
import com.example.BankManagementSystem.repository.AccountRepository;
import com.example.BankManagementSystem.repository.TransactionRepository;

@Service
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;
  

public TransactionService(TransactionRepository transactionRepository,AccountRepository accountRepository) {
	super();
	this.transactionRepository = transactionRepository;
	this.accountRepository = accountRepository;
}




//methods to call services

//important

public Transaction recordTransaction(Transaction transaction) {
	
	
	Long accountId = transaction.getAccount().getId();
	double amount = transaction.getAccount().getBalance();
	String type = transaction.getType();
	
	Account acc = accountRepository.findById(accountId).orElseThrow();

    if ("DEBIT".equalsIgnoreCase(type))
        acc.setBalance(acc.getBalance() - amount);
    else
        acc.setBalance(acc.getBalance() + amount);

    Transaction tx = new Transaction();
    tx.setAccount(acc);
    tx.setAmount(amount);
    tx.setType(type);
    tx.setTransactionDate(LocalDateTime.now());

    accountRepository.save(acc);
    return transactionRepository.save(tx);
}


public Optional<Transaction> getTransactionDetails(Long id)
{
	return transactionRepository.findById(id);
}
}
