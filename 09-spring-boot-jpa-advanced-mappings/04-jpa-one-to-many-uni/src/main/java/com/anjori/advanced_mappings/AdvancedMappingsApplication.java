package com.anjori.advanced_mappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anjori.advanced_mappings.dao.AppDAO;
import com.anjori.advanced_mappings.entity.Course;
import com.anjori.advanced_mappings.entity.Review;

@SpringBootApplication
public class AdvancedMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createCourseAndReview(appDAO);
			//retrieveCorseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		appDAO.deleteCourseById(1); // Assuming you want to delete course with ID 1`
	}

	private void retrieveCorseAndReviews(AppDAO appDAO) {
		int id = 1; // Assuming you want to retrieve course with ID 1
		Course course = appDAO.findCourseAndReviewsById(id);
		System.out.println("Retrieved course: " + course);
		System.out.println("Reviews: " + course.getReviews());
	}

	private void createCourseAndReview(AppDAO appDAO) {
		// Create a new course
		Course course = new Course();
		course.setTitle("Spring Boot Advanced Topics");

		// Add reviews to the course
		course.addReview(new Review(null, "Great course!"));
		course.addReview(new Review(null, "Very informative."));
		course.addReview(new Review(null, "Loved the hands-on examples."));
	   
		// save the course which will also save the reviews
		appDAO.save(course);

		System.out.println("Saved course: " + course);
		System.out.println("Reviews: " + course.getReviews());
	
	}
}
