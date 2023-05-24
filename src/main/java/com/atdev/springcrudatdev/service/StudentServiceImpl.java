package com.atdev.springcrudatdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atdev.springcrudatdev.entities.Student;
import com.atdev.springcrudatdev.exception.ResourceNotFoundException;
import com.atdev.springcrudatdev.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentrepo;
	
	
	public StudentServiceImpl(StudentRepository studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}


	@Override
	public Student saveStudent(Student student) {
		
			return studentrepo.save(student);
	}


	@Override
	public List<Student> getAllstudents() {
		
		return  studentrepo.findAll();
		}


	@Override
	public Student getStudentById(long id) {
		
		Optional<Student> student=studentrepo.findById(id);
			if(student.isPresent()) {
				return student.get();
			}
			else {
				throw new ResourceNotFoundException("Student", "id", id);
			}
	}


	@Override
	public Student updateStudent(Student student, long id) {
		//first chreck whet6hert student is their 
		
		Student existingstudent=studentrepo.findById(id).orElseThrow();
				existingstudent.setName(student.getName());
				studentrepo.save(existingstudent);
		return existingstudent;
	}


	@Override
	public void deleteStudent(long id) {
		studentrepo.deleteById(id);
		
	}
    
	
}
