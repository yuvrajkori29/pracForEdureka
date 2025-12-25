package com.studentcourse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public class CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addCourse(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Transactional
    public Course getCourseById(Long courseId) {
        return sessionFactory.getCurrentSession().get(Course.class, courseId);
    }

    @Transactional
    public List<Course> getAllCourses() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Course", Course.class)
                .getResultList();
    }

    @Transactional
    public Set<Student> getStudentsInCourse(Long courseId) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class, courseId);
        if (course != null) {
            Hibernate.initialize(course.getStudents()); // Load data while session is open
            return course.getStudents();
        }
        return null;
    }
}