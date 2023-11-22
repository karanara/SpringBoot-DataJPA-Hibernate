package com.example.springdatajpa.DAO;

import java.util.List;

import com.example.springdatajpa.Entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	Student findById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
	void update(Student theStudent);
}
