package com.example.entity;

public class Employee {
    private int empId;
    private String name;
    private String designation;

    // Constructor
    public Employee(int empId, String name, String designation) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
