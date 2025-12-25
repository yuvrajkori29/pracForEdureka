
package com.studentcourse;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "Course")
public class Course{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	@Column(name = "courseTitle")
	private String courseTitle;
	
	@Column(name = "courseDescription")
	private String courseDescription;
	
	@Column(name = "courseCredits")
	private Long courseCredits;
	
	@ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
	
	private Set<Student> students = new HashSet<>();
	
	
	public Course(Long courseId, String courseTitle, String courseDescription, Long courseCredits) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseDescription = courseDescription;
		this.courseCredits = courseCredits;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Long getCourseCredits() {
		return courseCredits;
	}
	public void setCourseCredits(Long courseCredits) {
		this.courseCredits = courseCredits;
	}
	
	public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
	
	
	
	
}