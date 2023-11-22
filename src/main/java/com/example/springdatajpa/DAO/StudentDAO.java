package com.example.springdatajpa.DAO;

import com.example.springdatajpa.Entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	Student findById(Integer id);
}
