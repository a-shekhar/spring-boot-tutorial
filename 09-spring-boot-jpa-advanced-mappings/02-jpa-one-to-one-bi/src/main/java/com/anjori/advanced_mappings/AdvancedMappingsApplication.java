package com.anjori.advanced_mappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anjori.advanced_mappings.dao.AppDAO;
import com.anjori.advanced_mappings.entity.Instructor;
import com.anjori.advanced_mappings.entity.InstructorDetail;

@SpringBootApplication
public class AdvancedMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteInstructorById(appDAO);
			//findInstructorDetailById(appDAO);
			deleteInstructorDetailsById(appDAO);

		};
	}

	private void deleteInstructorDetailsById(AppDAO appDAO) {
		int id = 4; // Assuming an instructor detail with ID 2 exists
		appDAO.deleteInstructorDetailsById(id);
		System.out.println("Deleted instructor detail with id: " + id);
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Found instructor detail: " + instructorDetail);
		System.out.println("Associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int instructorId = 1; // Assuming an instructor with ID 1 exists
		appDAO.deleteById(instructorId);
		System.out.println("Deleted instructor with id: " + instructorId);
	}

	private void findInstructorById(AppDAO appDAO) {
		int instructorId = 1; // Assuming an instructor with ID 1 exists
		Instructor instructor = appDAO.findById(instructorId);
	
		System.out.println("Found instructor: " + instructor);
		System.out.println("Found instructor Detail: " + instructor.getInstructorDetail());
	}


	private void createInstructor(AppDAO appDAO) {
		// create the instructor object
		Instructor instructor = new Instructor();
		instructor.setFirstName("John");
		instructor.setLastName("Doe");
		instructor.setEmail("john@anjori.com");

		// create the instructor detail object
		InstructorDetail instructorDetail = new InstructorDetail();
		instructorDetail.setYoutubeChannel("johnsChannel");
		instructorDetail.setHobby("Coding");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		appDAO.save(instructor);
		System.out.println("Saved instructor: " + instructor);
	}

}
