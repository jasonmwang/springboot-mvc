package com.infobase.courseselection.repository;

import org.springframework.data.repository.CrudRepository;

import com.infobase.courseselection.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
	
}
