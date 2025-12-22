package com.example.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Student;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Yuvraj", "yuvraj@gmail.com");
        Student s2 = new Student("Ramesh", "yuvraj@gmail.com");
        Student s3 = new Student("Hrishu", "yuvraj@gmail.com");
        session.save(s1);
        session.save(s2);
        session.save(s3);

        tx.commit();
        session.close();

        System.out.println("Data Inserted Successfully");
    }
}