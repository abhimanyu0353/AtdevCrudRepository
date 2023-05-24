package com.atdev.springcrudatdev.service;

import java.util.List;

import com.atdev.springcrudatdev.entities.Student;

public interface StudentService {

	Student saveStudent(Student student);
	//implemented in impl class
	
	List<Student> getAllstudents();
	
	Student getStudentById(long id) ;
	
	Student updateStudent(Student student,long id);
	
	void deleteStudent(long id);
}
