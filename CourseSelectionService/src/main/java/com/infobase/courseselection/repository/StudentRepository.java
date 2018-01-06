package com.infobase.courseselection.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infobase.courseselection.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	@Query("select r from Student r where r.name = :username and r.passwd = :passwd")
	public Student findStudent(@Param("username")String sName, @Param("passwd")String pwd);
}
