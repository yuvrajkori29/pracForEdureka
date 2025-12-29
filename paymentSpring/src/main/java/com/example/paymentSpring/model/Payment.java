package com.example.paymentSpring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
public class Payment{
	 @Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long paymentId;
	 
	 private String paymentMode;
	 private String payerName;
	 private double amountPaid;
	 private String paymentStatus;
	public Long getPaymentId() {
		return paymentId;
	}
	
	
	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	 
	 
	 
	 
	 
}