package com.anjori.advanced_mappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anjori.advanced_mappings.dao.AppDAO;
import com.anjori.advanced_mappings.entity.Course;
import com.anjori.advanced_mappings.entity.Student;

@SpringBootApplication
public class AdvancedMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createCourseAndStudents(appDAO);
			//findCourseAndStudentsById(appDAO);
			//findStudentAndCoursesByStudentId(appDAO);
			//addMoreCourseForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);	
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteStudentById(id);
		System.out.println("Deleted student with ID: " + id);
	}

	private void deleteCourse(AppDAO appDAO) {
		appDAO.deleteCourseById(1);
		System.out.println("Deleted course with ID 1");
	}

	private void addMoreCourseForStudent(AppDAO appDAO) {
		Course course1 = new Course();
		course1.setTitle("Android for Dummies");

		Course course2 = new Course();
		course2.setTitle("Java for Dummies");

		int id = 2; // Assuming we want to add courses for the student with ID 2
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		student.addCourse(course1);
		student.addCourse(course2);
		appDAO.update(student);
		System.out.println("Added more courses for student: " + student.getFirstName());

		appDAO.update(student);
	}

	private void findStudentAndCoursesByStudentId(AppDAO appDAO) {
		int id = 1; // Assuming we want to find the student with ID 1
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
		System.out.println("Courses enrolled by the student:");
		for (Course course : student.getCourses()) {
			System.out.println(" - " + course.getTitle());
		}
	}

	private void findCourseAndStudentsById(AppDAO appDAO) {
		int id = 1; // Assuming we want to find the course with ID 1
		Course course = appDAO.findCourseAndStudentsById(id);
		System.out.println("Course found: " + course.getTitle());
		System.out.println("Students enrolled in the course:");
		for (Student student : course.getStudents()) {
			System.out.println(" - " + student.getFirstName() + " " + student.getLastName());
		}
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// create a course
		Course course = new Course();
		course.setTitle("Spring Boot Advanced Mappings");

		// create the students
		Student student1 = new Student();
		student1.setFirstName("John");
		student1.setLastName("Doe");
		student1.setEmail("john@anjori.com");

		Student student2 = new Student();
		student2.setFirstName("Jane");
		student2.setLastName("Smith");
		student2.setEmail("jane@anjori.com");

		// add students to the course
		course.addStudent(student1);
		course.addStudent(student2);

		// save the course and associated students

		System.out.println("Saving course and students...");
		appDAO.saveCourse(course);
		System.out.println("Course and students saved successfully!");
		System.out.println("Course ID: " + course.getId());
		System.out.println("Students enrolled: ");
		for (Student student : course.getStudents()) {
			System.out.println(" - " + student.getFirstName() + " " + student.getLastName());
		}
	}

}
