package com.springboot.curddemo;

import com.springboot.curddemo.dao.StudentDAO;
import com.springboot.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner-> {
			// createStudent(studentDAO);
			 createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of student
		List<Student> students = studentDAO.findAll();

		// display list of students
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new Student object....");
		Student tempStudent = new Student("Aditya", "Raj", "araj@pscu.com");
		// saving the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		// display id of the saved item
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated Id " + theId);
		// retrieve student based on primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object");
		Student tempStudent1 = new Student("Joe", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Aditya", "Doe", "adi@gmail.com");
		Student tempStudent3 = new Student("Raj", "Doe", "raj@gmail.com");
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");
		// save the student to the database
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);
		// display the id of saved student
		System.out.println("Saved student... Generated Id: " + tempStudent.getId());
	}
}
