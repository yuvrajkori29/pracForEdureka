package com.example.BankManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
