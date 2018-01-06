package com.infobase.courseselection.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infobase.courseselection.dto.CourseDto;
import com.infobase.courseselection.dto.LoginResponse;
import com.infobase.courseselection.dto.RegisterCourseRequest;
import com.infobase.courseselection.dto.StudentDto;
import com.infobase.courseselection.entity.Student;
import com.infobase.courseselection.service.CourseSelectionService;

@RestController
@RequestMapping(value = "/courseSelection")
public class CourseSelectionController {

	@Autowired
	private CourseSelectionService courseSelectionService;
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> login(HttpServletRequest request, @RequestBody StudentDto studentDto) {
		
		Student studentResult = courseSelectionService.findStudent(studentDto.getName(), studentDto.getPasswd());
		LoginResponse loginResponse = new LoginResponse();
		if(studentResult == null){
			loginResponse.setResult("login-failed");
		}else{
			loginResponse.setResult("login-success");
		}
		return ResponseEntity.ok(loginResponse);
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerCourse", method = RequestMethod.POST)
	public ResponseEntity<List<StudentDto>> registerCourse(@RequestBody RegisterCourseRequest request) {
		
		String result = courseSelectionService.registerCourse(request.getStudentId(), request.getCourseId());
		
		if(result == null){
			throw new RuntimeException("register failed");
		}
		
		List<StudentDto> students = courseSelectionService.retrieveStudents(request.getCourseId());
		
		return ResponseEntity.ok(students);
	}
	
	@ResponseBody
	@RequestMapping(value = "/retrieveCourse", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDto>> retrieveCourse() {
		
		List<CourseDto> courses = courseSelectionService.retrieveCourse();
		
		return ResponseEntity.ok(courses);
	}
	
	@ResponseBody
	@RequestMapping(value = "/retrieveStudents", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDto>> retrieveStudents(@Param("courseId") Long courseId) {
		
		List<StudentDto> students = courseSelectionService.retrieveStudents(courseId);
		
		return ResponseEntity.ok(students);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public ResponseEntity<List<CourseDto>> addCourse( @RequestBody CourseDto courseDto) {
		
		List<CourseDto> courses = courseSelectionService.addCourse(courseDto.getCourseName());
		
		return ResponseEntity.ok(courses);
	}
}
