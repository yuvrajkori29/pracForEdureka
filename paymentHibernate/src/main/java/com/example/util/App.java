package com.example.util;

import java.util.List;
import com.example.entity.Payment;

public class App {
    public static void main(String[] args) {
       
        createPayment createPayment = new createPayment();
        readPayment readPayment = new readPayment();
        updatePayment updatePayment = new updatePayment();
        deletePayment deletePayment = new deletePayment();

       
        createPayment.createPaymentMethod("Credit Card");
        createPayment.createPaymentMethod("Debit Card");
        createPayment.createPaymentMethod("UPI");

       
        List<Payment> payments = readPayment.getPayments();
        if (payments != null && !payments.isEmpty()) {
            for (Payment payment : payments) {
                System.out.println(payment.getTypeofPayment());
            }
        } else {
            System.out.println("No payments found.");
        }

       
        updatePayment.updatePaymentMethod(1, "PayPal");

     
        deletePayment.deletePaymentMethod(2); 
    }
}
