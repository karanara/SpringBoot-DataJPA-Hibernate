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
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		Student newStudent1 = new Student("Jishna","Karanam","joshna@gmail.com");
		Student newStudent2 = new Student("josh","Karanam","jo123@gmail.com");
		Student newStudent3 = new Student("bujji","Karanam","baby123@gmail.com");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
		System.out.println("Saved Student.Generated id: "+newStudent1.getId());
		System.out.println("Saved Student.Generated id: "+newStudent2.getId());
		System.out.println("Saved Student.Generated id: "+newStudent3.getId());

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
