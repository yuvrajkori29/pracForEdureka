package com.example.paymentSpring.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.paymentSpring.model.Payment;
import com.example.paymentSpring.repository.paymentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // Lombok will create the constructor for dependency injection
public class paymentService {

    private final paymentRepository paymentRepo; 
    
    paymentService(paymentRepository paymentRepo)
    {
    	this.paymentRepo = paymentRepo;
    }
    
    // Get payment by ID
    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepo.findById(paymentId);
    }

    // Add a new payment
    public void addPayment(Payment payment) {
        paymentRepo.save(payment);
    }

    // Delete payment by ID
    public void deletePayment(Long paymentId) {
        paymentRepo.deleteById(paymentId);
    }

    // Update an existing payment
    public void updatePayment(Long paymentId, Payment updatedPayment) {
        Payment existingPayment = paymentRepo.findById(paymentId).orElse(null);

        if (existingPayment != null) {
            // Update fields if the payment exists
            existingPayment.setAmountPaid(updatedPayment.getAmountPaid());
            existingPayment.setPaymentMode(updatedPayment.getPaymentMode());
            existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
            existingPayment.setPayerName(updatedPayment.getPayerName());
            paymentRepo.save(existingPayment);
        } 
    }
}
