package com.example.springdatajpa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdatajpa.Entity.Student;

import jakarta.persistence.EntityManager;


@Repository
public class StudentDAOImpl implements StudentDAO {
   

//Define the Entity Manager as a field
	private EntityManager entityManager;
	
	//injecting the entityManager through constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//implementing the save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

}
