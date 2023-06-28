package com.luv2code.crudDemo;

import com.luv2code.crudDemo.dao.AppDAO;
import com.luv2code.crudDemo.entity.Instructor;
import com.luv2code.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Delete instructor " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done...");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor" +instructor);
		System.out.println("the associated instructor details only " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
/*
		// crate instructor
		Instructor tempInstructor = new Instructor("Aditya", "Raj", "smart@abc.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "Singing");
*/

		// crate instructor
		Instructor tempInstructor = new Instructor("Jyotsna", "Raj", "dumb@abc.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/bhutiya", "nakhra");


		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		System.out.println("Saving Instructor ..." + tempInstructor);
        appDAO.save(tempInstructor);
		System.out.println("Saved Instructor ... ");

	}
}
