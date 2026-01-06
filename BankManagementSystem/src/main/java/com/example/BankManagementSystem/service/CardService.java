package com.example.BankManagementSystem.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.model.Account;
import com.example.BankManagementSystem.model.Card;
import com.example.BankManagementSystem.repository.AccountRepository;
import com.example.BankManagementSystem.repository.CardRepository;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
	public CardService(CardRepository cardRepository, AccountRepository accountRepository) {
		super();
		this.cardRepository = cardRepository;
		this.accountRepository = accountRepository;
	}
    
    
    //method calls
	
	public Card issueCard(Long accountId, Card card) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        card.setAccount(account);
        return cardRepository.save(card);
    }
	
	public Optional<Card> getCardDetails(Long id)
	{
		return cardRepository.findById(id);
	}
}
