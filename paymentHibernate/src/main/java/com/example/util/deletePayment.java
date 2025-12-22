package com.example.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Payment;

public class deletePayment {

    public void deletePaymentMethod(int paymentId) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Fetch the payment by ID
            Payment payment = session.get(Payment.class, paymentId);

            if (payment != null) {
                // Delete the payment
                session.delete(payment);
                tx.commit();
                System.out.println("Payment deleted successfully!");
            } else {
                System.out.println("Payment with ID " + paymentId + " not found.");
            }
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
