package com.example.aop;

public class PaymentService{
	public void makePayment(String account, double amount)
	{
	  System.out.println("payment" + amount + "account" + account);
	}
}