package com.example.BankManagementSystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.model.Card;
import com.example.BankManagementSystem.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController{
	private final CardService cardService;

	public CardController(CardService cardService) {
		super();
		this.cardService = cardService;
	}
	
	
	@PostMapping
	public Card issueCard(@RequestBody Card card)
	{
		return cardService.issueCard(card);
	}
	
	@GetMapping("/{id}")
	public Card getCardDetails(@PathVariable Long id) {
	    return cardService.getCardDetails(id);
	}
}