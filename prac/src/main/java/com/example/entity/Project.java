package com.example.entity;


import java.time.LocalDate;

public class Project {
    private int projectId;
    private String projectName;
    private LocalDate deadline;

    // Constructor
    public Project(int projectId, String projectName, LocalDate deadline) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.deadline = deadline;
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
