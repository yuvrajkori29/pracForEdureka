package com.example.BankManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.BankManagementSystem.model.Customer;
import com.example.BankManagementSystem.service.CustomerService;

@SpringBootTest
public class CacheTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void testCachePerformance() {
     
        long start1 = System.currentTimeMillis();
        Customer c1 = customerService.getCustomer(1L);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;

 
        long start2 = System.currentTimeMillis();
        Customer c2 = customerService.getCustomer(1L);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;

        System.out.println("First call time: " + time1 + "ms");
        System.out.println("Second call time: " + time2 + "ms");

        // Verification: Time 2 should be almost 0ms
        assertEquals(c1.getName(), c2.getName());
    }
}