
package com.studentcourse;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(name = "studentName")
	private String studentName;
	
	@Column(name = "studentEmail")
	private String studentEmail;
	
	@Column(name = "enrollmentDate")
	private Date Date;
	
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	private Set<Course> listCourses = new HashSet<>();


	
	//constructor;
	public Student(Long id, String studentName, String studentEmail, Date localDate) {
		super();
		this.studentId = id;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.Date = localDate;
	}
	
	
	//getters and setters

	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Long getstudentId () {
		return studentId ;
	}

	public void setId(Long id) {
		this.studentId  = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Date getLocalDate() {
		return Date;
	}

	public void setLocalDate(Date date) {
		this.Date = date;
	}


    public void setListCourses(Set<Course> listCourses) {
        this.listCourses = listCourses;
    }
	public Set<Course> getListCourses() {
		return listCourses;
	}


	
	
	
	
	
	
	
	
}