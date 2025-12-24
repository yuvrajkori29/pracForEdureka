package com.example.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.util.DBUtil;

public class ProjectDAO {

    public void addProject(Project project) {
        String query = "INSERT INTO Project (projectId, projectName, deadline) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, project.getProjectId());
            stmt.setString(2, project.getProjectName());
            stmt.setDate(3, Date.valueOf(project.getDeadline()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getProjectById(int projectId) {
        String query = "SELECT * FROM Project WHERE projectId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Project(rs.getInt("projectId"), rs.getString("projectName"), rs.getDate("deadline").toLocalDate());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProject(Project project) {
        String query = "UPDATE Project SET projectName = ?, deadline = ? WHERE projectId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, project.getProjectName());
            stmt.setDate(2, Date.valueOf(project.getDeadline()));
            stmt.setInt(3, project.getProjectId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(int projectId) {
        String query = "DELETE FROM Project WHERE projectId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, projectId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM Project";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                projects.add(new Project(rs.getInt("projectId"), rs.getString("projectName"), rs.getDate("deadline").toLocalDate()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
