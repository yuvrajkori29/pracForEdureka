package com.example.BankManagementSystem.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.model.Transaction;
import com.example.BankManagementSystem.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
    
	
	@PostMapping
	public Transaction recordTransaction(@RequestBody Transaction transaction)
	{
		return transactionService.recordTransaction(transaction);
	}
	
	@GetMapping("/{id}")
	public Optional<Transaction> getTransactionDetails(@PathVariable Long id)
	{
		return transactionService.getTransactionDetails(id);
	}
}
