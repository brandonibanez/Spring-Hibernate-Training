package com.brandoncode.cruddemo;

import com.brandoncode.cruddemo.dao.AppDAO;
import com.brandoncode.cruddemo.entity.Instructor;
import com.brandoncode.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(AppDAO appDao) {
		return runner -> {
			createInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
			deleteInstructorDetailById(appDao, 1);
			System.out.println("Done!");
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO, int theId) {
		int id = theId;
		try {
			appDAO.deleteInstructorDetailById(id);
			System.out.println("Deleted instructor details with id: " + id);
		} catch (Exception ignored) {
			System.out.println("Id: " + id + " is not present");
		}
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor detail with id of " + id + ": " + instructorDetail);
		System.out.println("Instructor associated with the details: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Delete instructor id: " + id);
		try {
			appDAO.deleteInstructorById(id);
		} catch (Exception ignored) {
			System.out.println("Id: " + id + " is not present");
		}
	}

	private void findInstructor(AppDAO appDAO) {
		try {
			Optional<Instructor> instructor = Optional.of(appDAO.findInstructorById(1));
			System.out.println("Instructor is present: " + instructor.get());
			System.out.println("Instructor details: " + instructor.get().getInstructorDetail());
		} catch(Exception e) {
			System.out.println("Instructor is not present");
		}
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Brandon", "Browns", "brandon@gmail.com");
		instructor.setInstructorDetail(
				new InstructorDetail(
						"www.brandon.com",
						"code code")
		);
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
	}
}
