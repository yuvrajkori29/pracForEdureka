package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Payment;

public class HibernateUtil{
	 
	public static SessionFactory sessionFactory = null;
	static {
	try {
		sessionFactory  = new Configuration().configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Payment.class).buildSessionFactory();
		 
	}catch(Exception e)
	{
		 System.out.println("Error creating SessionFactory: " + e.getMessage());
		    e.printStackTrace();
		   
	}
	}
	 
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


