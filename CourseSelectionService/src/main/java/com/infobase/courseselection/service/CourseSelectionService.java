package com.infobase.courseselection.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infobase.courseselection.dto.CourseDto;
import com.infobase.courseselection.dto.StudentDto;
import com.infobase.courseselection.entity.Course;
import com.infobase.courseselection.entity.Student;
import com.infobase.courseselection.repository.CourseRepository;
import com.infobase.courseselection.repository.StudentRepository;

@Service
public class CourseSelectionService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional(readOnly = true)
	public Student findStudent(String sName, String pwd) {
		Student student = studentRepository.findStudent(sName, pwd);
		
		return student;
	}

	@Transactional(readOnly = true)
	public List<CourseDto> retrieveCourse() {
		Iterator<Course> courseIt = courseRepository.findAll().iterator();
		List<CourseDto> courseList = new ArrayList<CourseDto>();
		while(courseIt.hasNext()){
			Course course = courseIt.next();
			CourseDto courseDto = new CourseDto();
			courseDto.setId(course.getId());
			courseDto.setCourseName(course.getCourseName());
			courseList.add(courseDto);
		}
		return courseList;
	}

	@Transactional
	public List<CourseDto> addCourse(String courseName) {
		Course course = new Course();
		course.setCourseName(courseName);
		courseRepository.save(course);
		return retrieveCourse();
	}

	@Transactional(readOnly = true)
	public List<StudentDto> retrieveStudents(Long courseId) {
		Iterator<Student> studentIt = studentRepository.findAll().iterator();
		List<StudentDto> studentList = new ArrayList<StudentDto>();
		while(studentIt.hasNext()){
			Student student = studentIt.next();
			StudentDto studentDto = new StudentDto();
			studentDto.setId(student.getId());
			studentDto.setName(student.getName());
			studentList.add(studentDto);
		}
		List<Long> studentIdList = null;
		if(courseId != null && courseId > 0){
			Course course = courseRepository.findOne(courseId);
			List<Student> courseStudentList = course.getStudentList();
			studentIdList = courseStudentList.stream().map(s -> s.getId()).collect(Collectors.toList());
		}
		if(CollectionUtils.isNotEmpty(studentIdList)){
			final List<Long> ids = new ArrayList<Long>(studentIdList);
			studentList = studentList.stream().filter(s -> !ids.contains(s.getId())).collect(Collectors.toList());
		}
		
		return studentList;
	}
	
	public String registerCourse(Long studentId, Long courseId) {
	
		return null;
	}
}
