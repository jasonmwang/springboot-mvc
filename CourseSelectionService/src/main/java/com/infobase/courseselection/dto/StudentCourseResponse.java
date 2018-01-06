package com.infobase.courseselection.dto;

import java.io.Serializable;
import java.util.List;

public class StudentCourseResponse implements Serializable{

	private static final long serialVersionUID = -4519707885477575132L;

	private StudentDto student;
	private List<CourseDto> rfcConnectionList;
	public StudentDto getStudent() {
		return student;
	}
	public void setStudent(StudentDto student) {
		this.student = student;
	}
	public List<CourseDto> getRfcConnectionList() {
		return rfcConnectionList;
	}
	public void setRfcConnectionList(List<CourseDto> rfcConnectionList) {
		this.rfcConnectionList = rfcConnectionList;
	}
}
