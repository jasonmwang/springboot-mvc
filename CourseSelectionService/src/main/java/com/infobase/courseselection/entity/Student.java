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
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PASSWD")
	private String passwd;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_STUDENT", joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"), 
    inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
	private List<Course> courseList;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
