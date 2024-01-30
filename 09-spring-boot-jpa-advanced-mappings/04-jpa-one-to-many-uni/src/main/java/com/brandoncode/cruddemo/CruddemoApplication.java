package com.brandoncode.cruddemo;

import com.brandoncode.cruddemo.dao.AppDAO;
import com.brandoncode.cruddemo.entity.Course;
import com.brandoncode.cruddemo.entity.Instructor;
import com.brandoncode.cruddemo.entity.InstructorDetail;
import com.brandoncode.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(AppDAO appDao) {
		return runner -> {
//			createCourseAndReviews(appDao);
//			retrieveCourseAndReviews(appDao);
			deleteCourseAndReviews(appDao);
			System.out.println("Done!");
		};
	}

	private void deleteCourseAndReviews(AppDAO appDao) {
		int id=10;

		System.out.println("Deteleting course id: " + id);

		appDao.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(AppDAO appDao) {
		int id=10;
		System.out.println("Finding course id: " + id);
		Course course = appDao.findCourseAndReviewsByCourseId(id);

		System.out.println("Instructor detail with id of " + id + ": " + course);
		System.out.println("Instructor associated with the details: " + course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDao) {
		Course course = new Course("Brandon Browns Super Amazing Masterclasses");

		course.addReview(new Review("This is the best course in the world men!"));
		course.addReview(new Review("I will buy this course again and again for the rest of my life!"));

		System.out.println("Saving the course: " + course);
		System.out.println(course);
		System.out.println(course.getReviews());

		appDao.save(course);
	}

	private void deleteCourse(AppDAO appDao) {
		int id = 1;
		System.out.println("Deleting course id: " + id);
		appDao.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDao) {
		int id=1;
		System.out.println("Finding course id: " + id);
		Course course = appDao.findCourseById(id);

		course.setTitle("Super Rabby Dabby");

		appDao.update(course);
	}

	private void updateInstructor(AppDAO appDao) {
		int id=1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findByInstructorIdJoinFetch(id);

		System.out.println("Updating instructor id: "+ id);
		instructor.setLastName("RabbyDabby");

		appDao.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDao) {
		int id=1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findByInstructorIdJoinFetch(id);

		System.out.println("Instructor detail with id of " + id + ": " + instructor);
		System.out.println("Instructor associated with the details: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDao) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findInstructorById(id);
		instructor.setCourses(appDao.findCourseByInstructorId(id));

		System.out.println("Instructor detail with id of " + id + ": " + instructor);
		System.out.println("Instructor associated with the details: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDao) {
		//Set courses fetch type to Eager inside Instructor Entity to work
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor detail with id of " + id + ": " + instructor);
		System.out.println("Instructor associated with the details: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Brandon", "Browns", "brandon@gmail.com");
		instructor.setInstructorDetail(
				new InstructorDetail(
						"www.brandon.com",
						"code code")
		);
		instructor.add(new Course("Brandon Lecture Time"));
		instructor.add(new Course("Brandon Masterclass"));
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		appDAO.save(instructor);
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
