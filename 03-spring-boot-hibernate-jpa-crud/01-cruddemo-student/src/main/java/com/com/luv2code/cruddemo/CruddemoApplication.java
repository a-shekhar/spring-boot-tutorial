package com.com.luv2code.cruddemo;

import com.com.luv2code.cruddemo.dao.StudentDAO;
import com.com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			 createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

	        //queryForStudents(studentDAO);

			//queryForStudentsByFirstname(studentDAO);

			//updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}



	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new Student Object ...");

		Student theStudent = new Student("Paul", "Doe", "paul@abc.com");

		System.out.println("Saving the Student ...");
		studentDAO.save(theStudent);

		System.out.println("Saved Student. Generated id: " + theStudent.getId());
	}

	private void createMultipleStudent(StudentDAO studentDAO){
		System.out.println("Creating 3 student objects...");
		Student theStudent1 = new Student("Aditya", "Raj", "aditya@abc.com");
		Student theStudent2 = new Student("Jyotsna", "Raj", "joey@abc.com");
		Student theStudent3 = new Student("Anu", "Raj", "anu@abc.com");

		// save the student objects
		System.out.println("Saving the Students ...");
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);


	}

	private void readStudent(StudentDAO studentDAO){
		System.out.println("Creating new Student Object ...");

		Student theStudent = new Student("Aayan", "Raj", "swaggy@abc.com");

		System.out.println("Saving the Student ...");
		studentDAO.save(theStudent);

		int theId = theStudent.getId();
		System.out.println("Saved Student. Generated id: " + theId);

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id:" + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsByFirstname(StudentDAO studentDAO) {
		// get a list of Students
		List<Student> theStudents = studentDAO.findByFirstName("Jyotsna");
		//display list of Students
		for(Student student: theStudents){
			System.out.println(student);
		}

	}

	private void updateStudent(StudentDAO studentDAO){
		// retrieve student based on id
		int id = 4;
		System.out.println("Getting Student with id: " +id);
		Student student = studentDAO.findById(id);

		System.out.println("Updating Student...");
		student.setFirstName("Aryan");

		// update the student
		studentDAO.update(student);
		System.out.println("Updated Student: " + student);
	}

	private void deleteStudent(StudentDAO studentDAO){
		int id = 4;
		System.out.println("Deleting Student id: " + id);

		studentDAO.delete(id);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + rowsDeleted);
	}
}
