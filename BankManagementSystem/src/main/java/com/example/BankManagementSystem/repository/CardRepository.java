package com.example.BankManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
