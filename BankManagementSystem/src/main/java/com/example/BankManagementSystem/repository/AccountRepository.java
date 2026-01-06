package com.example.BankManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
