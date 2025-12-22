package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "payment")  // specify the table name if necessary
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String typeofPayment;

    // Constructor
    public Payment(String typeofPayment) {
        this.typeofPayment = typeofPayment;
    }

    // Getter and Setter for typeofPayment
    public String getTypeofPayment() {
        return typeofPayment;
    }

    public void setTypeofPayment(String typeofPayment) {
        this.typeofPayment = typeofPayment;
    }

    // Optional: Default constructor for Hibernate
    public Payment() {
    }
}
