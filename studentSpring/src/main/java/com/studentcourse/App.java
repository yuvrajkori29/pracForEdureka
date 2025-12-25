package com.studentcourse;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
public class App{
	
	
	public static void main(String[] args)
	{
		 ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

	        // Get the service beans
		 StudentDAO studentService = (StudentDAO) context.getBean("studentDAO");
		 CourseDAO courseService = (CourseDAO) context.getBean("courseDAO");


	        // Create sample courses
	        Course course1 = new Course();
	        course1.setCourseTitle("Java Programming");
	        course1.setCourseDescription("Learn Java programming from scratch");
	        course1.setCourseCredits(4L);

	        Course course2 = new Course();
	        course2.setCourseTitle("Database Management");
	        course2.setCourseDescription("Learn how to manage and interact with databases");
	        course2.setCourseCredits(3L);

	        // Add courses to database
	        courseService.addCourse(course1);
	        courseService.addCourse(course2);

	        // Create a new student
	        Student student1 = new Student();
	        student1.setStudentName("John Doe");
	        student1.setStudentEmail("john.doe@example.com");
	        student1.setLocalDate(new Date());

	        // Add the student to the database
	        studentService.addStudent(student1);
	        
	        //add course to student
	        studentService.addCourseToStudent(student1.getstudentId(),course1.getCourseId());
	        studentService.addCourseToStudent(student1.getstudentId(), course2.getCourseId());

	        
	        List<Student>studentsList  = studentService.getAllStudents();
	        
	        for(Student st : studentsList)
	        {
	        	System.out.println(st);
	        }
	        
	}
}
 