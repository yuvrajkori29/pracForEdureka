package com.example.BankManagementSystem.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
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
	public Card issueCard(@RequestBody Long id,@RequestBody Card card)
	{
		return cardService.issueCard(id,card);
	}
	
	@GetMapping("/{id}")
	public Optional<Card> getCardDetails(@RequestBody Long id)
	{
		return cardService.getCardDetails(id);
	}
}