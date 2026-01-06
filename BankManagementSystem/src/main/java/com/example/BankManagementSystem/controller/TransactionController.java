package com.example.BankManagementSystem.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Transaction recordTransaction(@PathVariable Long id,@PathVariable double amount,@PathVariable String type)
	{
		return transactionService.recordTransaction(id, amount, type);
	}
	
	@GetMapping("/{id}")
	public Optional<Transaction> getTransactionDetails(@PathVariable Long id)
	{
		return transactionService.getTransactionDetails(id);
	}
}
