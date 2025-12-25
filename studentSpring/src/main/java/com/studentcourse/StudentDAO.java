package com.studentcourse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Transactional
    public void updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    @Transactional
    public Student getStudentById(Long studentId) {
        return sessionFactory.getCurrentSession().get(Student.class, studentId);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Student", Student.class)
                .getResultList();
    }

    @Transactional
    public void addCourseToStudent(Long studentId, Long courseId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        Course course = session.get(Course.class, courseId);

        if (student != null && course != null) {
            // IMPORTANT: Course is the OWNER of the relationship (@JoinTable).
            // We must add the student to the course's set for Hibernate to update the join table.
            course.getStudents().add(student);
            student.getListCourses().add(course);

            // Updating the owner (course) is what triggers the SQL INSERT into student_courses
            session.update(course);
        }
    }

    @Transactional
    public Set<Course> getCoursesForStudent(Long studentId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        if (student != null) {
            Hibernate.initialize(student.getListCourses()); // Prevents LazyInitializationException
            return student.getListCourses();
        }
        return null;
    }
}