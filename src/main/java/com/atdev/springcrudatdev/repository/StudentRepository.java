package com.atdev.springcrudatdev.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.atdev.springcrudatdev.entities.Student;
//jpa repository internally provides @repository so dont need to add 
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
}
