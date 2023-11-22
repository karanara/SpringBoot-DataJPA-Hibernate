package com.example.springdatajpa.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdatajpa.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


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
	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method student
		//syntax for creatign a query to read all data
		TypedQuery<Student> typedQuery= entityManager.createQuery("FROM Student",Student.class);
		return typedQuery.getResultList();
	}
	@Override
	public List<Student> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student where lastName = :theData",Student.class);
		typedQuery.setParameter("theData",lastName);
		return typedQuery.getResultList();
	}
}
