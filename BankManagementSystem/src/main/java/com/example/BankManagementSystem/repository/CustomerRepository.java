package com.example.BankManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankManagementSystem.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
