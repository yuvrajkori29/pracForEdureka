package com.example.BankManagementSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.example.BankManagementSystem.model.Customer;
import com.example.BankManagementSystem.service.CustomerService;

@SpringBootTest
class BankManagementSystemApplicationTests {

	

	@Autowired
    private CustomerService customerService;

    @Test
    void testAddAndGetCustomer() {
        // 1. Create a customer object
        Customer c = new Customer();
        c.setName("John Smith");

        // 2. Use your real service to save it to your real DB
        Customer saved = customerService.addCustomer(c);
        
        // 3. Use your service to find it by ID
        Customer found = customerService.getCustomer(saved.getId());

        // 4. Simple Assertions (Checking the result)
        assertNotNull(found);
        assertEquals("John Smith", found.getName());
    }

	
}



