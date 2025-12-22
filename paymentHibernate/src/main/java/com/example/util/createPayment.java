package com.example.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Payment;

public class createPayment {

    public void createPaymentMethod(String paymentMethod) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Create a new payment
            Payment newPayment = new Payment(paymentMethod);

         
            session.save(newPayment);
            tx.commit();
            System.out.println("Payment created successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
