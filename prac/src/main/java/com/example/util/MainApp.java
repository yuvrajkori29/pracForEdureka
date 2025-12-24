package com.example.util;

import com.example.entity.EmployeeDAO;
import com.example.entity.Project;
import com.example.entity.ProjectDAO;

import java.time.LocalDate;
import java.util.List;

import com.example.entity.AssignmentDAO;
import com.example.entity.Employee;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        AssignmentDAO assignmentDAO = new AssignmentDAO();

        // Create Employees
        Employee emp1 = new Employee(1, "John Doe", "Developer");
        Employee emp2 = new Employee(2, "Jane Smith", "Manager");

        // Add Employees
        employeeDAO.addEmployee(emp1);
        employeeDAO.addEmployee(emp2);

        // Create Projects (corrected)
        LocalDate project1Deadline = LocalDate.parse("2025-12-31");
        LocalDate project2Deadline = LocalDate.parse("2025-06-30");
        
        Project project1 = new Project(1, "Project A", project1Deadline);
        Project project2 = new Project(2, "Project B", project2Deadline);

        // Add Projects
        projectDAO.addProject(project1);
        projectDAO.addProject(project2);

        // Assign Employees to Projects
        assignmentDAO.assignEmployeeToProject(emp1.getEmpId(), project1.getProjectId());
        assignmentDAO.assignEmployeeToProject(emp2.getEmpId(), project1.getProjectId());

        // Optionally, print out assignments to verify
        System.out.println("Employee 1 is assigned to Project A.");
        System.out.println("Employee 2 is assigned to Project A.");

        // Retrieve all projects for Employee 1
        List<Project> emp1Projects = assignmentDAO.getAllProjectsForEmployee(emp1.getEmpId());
        System.out.println("Projects assigned to Employee 1:");
        for (Project p : emp1Projects) {
            System.out.println(p);
        }

        // Retrieve all employees for Project 1
        List<Employee> project1Employees = assignmentDAO.getAllEmployeesForProject(project1.getProjectId());
        System.out.println("Employees assigned to Project A:");
        for (Employee e : project1Employees) {
            System.out.println(e);
        }
    }
}