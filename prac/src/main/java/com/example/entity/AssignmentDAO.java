package com.example.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.util.DBUtil;

public class AssignmentDAO {

    // Method to assign an employee to a project
    public void assignEmployeeToProject(int empId, int projectId) {
        String query = "INSERT INTO Assignments (empId, projectId) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            stmt.setInt(2, projectId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to remove an employee from a project
    public void removeAssignment(int empId, int projectId) {
        String query = "DELETE FROM Assignments WHERE empId = ? AND projectId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            stmt.setInt(2, projectId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all projects assigned to a specific employee
    public List<Project> getAllProjectsForEmployee(int empId) {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT p.projectId, p.projectName, p.deadline " +
                       "FROM Project p JOIN Assignments a ON p.projectId = a.projectId WHERE a.empId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                projects.add(new Project(
                        rs.getInt("projectId"),
                        rs.getString("projectName"),
                        rs.getDate("deadline").toLocalDate()
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    // Method to retrieve all employees assigned to a specific project
    public List<Employee> getAllEmployeesForProject(int projectId) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT e.empId, e.name, e.designation " +
                       "FROM Employee e JOIN Assignments a ON e.empId = a.empId WHERE a.projectId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("designation")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
