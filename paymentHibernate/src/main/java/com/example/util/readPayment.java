package com.example.util;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Payment;

public class readPayment {

    public List<Payment> getPayments() {
        Session session = null;
        Transaction tx = null;
        List<Payment> payments = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Fetch all payments using HQL
            String hql = "FROM Payment";
            payments = session.createQuery(hql, Payment.class).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return payments;
    }
}
