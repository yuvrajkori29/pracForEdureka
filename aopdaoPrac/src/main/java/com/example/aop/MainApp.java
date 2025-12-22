
package com.example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");
        paymentService.makePayment("ACC123", 500.0);
        paymentService.makePayment("ACC123", 200.0);
    }
}


