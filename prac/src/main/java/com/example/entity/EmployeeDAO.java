package com.example.entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.util.DBUtil;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (empId, name, designation) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, employee.getEmpId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getDesignation());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployeeById(int empId) {
        String query = "SELECT * FROM Employee WHERE empId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Employee(rs.getInt("empId"), rs.getString("name"), rs.getString("designation"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET name = ?, designation = ? WHERE empId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDesignation());
            stmt.setInt(3, employee.getEmpId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId) {
        String query = "DELETE FROM Employee WHERE empId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                employees.add(new Employee(rs.getInt("empId"), rs.getString("name"), rs.getString("designation")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
