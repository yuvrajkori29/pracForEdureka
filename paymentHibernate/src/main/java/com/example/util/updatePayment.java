package com.example.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Payment;

public class updatePayment {

    public void updatePaymentMethod(int paymentId, String newPaymentMethod) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Fetch the payment by ID
            Payment payment = session.get(Payment.class, paymentId);

            if (payment != null) {
                // Update the payment method
                payment.setTypeofPayment(newPaymentMethod);
                session.update(payment);
                tx.commit();
                System.out.println("Payment updated successfully!");
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
