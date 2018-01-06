package com.infobase.courseselection.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_STUDENT", joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"), 
    inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
	private List<Student> studentList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
