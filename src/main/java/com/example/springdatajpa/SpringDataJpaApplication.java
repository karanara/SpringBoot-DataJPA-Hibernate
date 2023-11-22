package com.example.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springdatajpa.DAO.StudentDAO;
import com.example.springdatajpa.Entity.Student;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	//Executed after all Spring beans have loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("creating new Student Object");
		Student newStudent = new Student("Ramya","Karanam","ramya123@gmail.com");
		//saving the studnet into database
		System.out.println("Saving the student object");
		studentDAO.save(newStudent);
		//display id of the saved Student
		System.out.println("displaying id of the saved student");
		System.out.println("Saved Student.Generated id: "+newStudent.getId());
	}

}
