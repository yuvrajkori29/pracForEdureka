package com.example.paymentSpring.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentSpring.Service.paymentService;
import com.example.paymentSpring.model.Payment;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class paymentController{
	

	private final paymentService paymentServ;
	 paymentController(paymentService paymentServ)
	    {
	    	this.paymentServ = paymentServ;
	    }
	    
	
	@GetMapping("/{paymentId}")
	public Optional<Payment> getPaymentById(@PathVariable Long paymentId)
	{
		return paymentServ.getPaymentById(paymentId);
	}
	
	@PostMapping
	public ResponseEntity<String> addPayment(@RequestBody Payment payment){
		try {
            paymentServ.addPayment(payment);
            return ResponseEntity.ok("Payment added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add payment: " + e.getMessage());
        }
	}
	
	@PutMapping("/{paymentId}")
    public ResponseEntity<String> updatePayment(@PathVariable Long paymentId, @RequestBody Payment updatedPayment) {
        try {
            paymentServ.updatePayment(paymentId, updatedPayment);
            return ResponseEntity.ok("Payment updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Payment not found: " + e.getMessage());
        }
    }
	
	@DeleteMapping("/{delete}")
	public ResponseEntity<String> deletePayment(@PathVariable Long paymentId)
	{
		 try {
	            paymentServ.deletePayment(paymentId);
	            return ResponseEntity.ok("Payment updated successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(404).body("Payment not found: " + e.getMessage());
	        }
	}
	
	
}