package com.saleslead;

import com.saleslead.dao.LeadDAO;
import com.saleslead.dao.SalespersonDAO;
import com.saleslead.entity.Lead;
import com.saleslead.entity.Salesperson;
import com.saleslead.entity.Status;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // Create Spring context
    	  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get DAO Beans
        SalespersonDAO salespersonDAO = context.getBean(SalespersonDAO.class);
        LeadDAO leadDAO = context.getBean(LeadDAO.class);

        // CRUD Example
        Salesperson salesperson = new Salesperson("John Doe", "john.doe@example.com", "North");
        salespersonDAO.save(salesperson);

        Lead lead = new Lead("TechCo", "Alice", Status.NEW);
        leadDAO.save(lead);

        System.out.println("Salesperson saved with id: " + salesperson.getId());
        System.out.println("Lead saved with id: " + lead.getId());

        context.close();
    }
}
