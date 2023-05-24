package com.atdev.springcrudatdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.springcrudatdev.entities.Student;
import com.atdev.springcrudatdev.service.StudentService;

@RestController
@RequestMapping("/api/students")  
public class StudentController {
	@Autowired
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	//cretae student rest api
	
	//requestbody annotation allows us to retrieve requests body and automatically cobvet it to java object
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		studentservice.saveStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}

	//get all student api
	@GetMapping("/getAllStudents")
	public List<Student> getStudents(){
		return studentservice.getAllstudents();
	} 
	
	//get emloyee by id api
	@GetMapping("{id}")
	public ResponseEntity<Student> getEmployeeByid(@PathVariable("id") long sid){
		return new ResponseEntity<Student>(studentservice.getStudentById(sid), HttpStatus.OK);
	}
	//updatre student api
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id")long id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentservice.updateStudent(student, id), HttpStatus.OK);
	}
	
	//delete student api
	@DeleteMapping()
	public ResponseEntity<String> deleyteStudent(@PathVariable("id") long id){
		studentservice.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted", HttpStatus.OK);
	}
}
