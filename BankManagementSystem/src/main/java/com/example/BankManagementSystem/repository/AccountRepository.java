package com.example.BankManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
List<Account> findByCustomerId(Long id);
}
