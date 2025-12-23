package com.example.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Course;
import com.example.entity.Student;

public class App{

    public static void main(String[] args) {
        
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create student and course objects
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setEmail("john@example.com");
        student1.setEnrollmentDate("2025-01-01");

        Course course1 = new Course();
        course1.setTitle("Math 101");
        course1.setDescription("Basic Math course.");
        course1.setCredits(3);

        Course course2 = new Course();
        course2.setTitle("History 101");
        course2.setDescription("Basic History course.");
        course2.setCredits(3);

        // Add courses to student
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);

        // Add student to courses
        course1.getStudents().add(student1);
        course2.getStudents().add(student1);

        // Save student and courses
        session.save(student1);
        session.save(course1);
        session.save(course2);

        // Commit transaction
        transaction.commit();

        // Close session
        session.close();

        System.out.println("Student and courses have been saved successfully.");
    }
}
