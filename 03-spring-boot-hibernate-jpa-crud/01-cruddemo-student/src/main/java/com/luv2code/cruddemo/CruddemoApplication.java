package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int rows = studentDAO.deleteAll();
		System.out.println("Numbers of rows deleted: " + rows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		queryForStudent(studentDAO);

		studentDAO.delete(3);

		System.out.println("Deleted student with id 3");

		queryForStudent(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);

		System.out.println("Before update: " + student);

		student.setFirstName("Scooby");

		System.out.println("After update: " + student);

		studentDAO.update(student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> list = studentDAO.findByLastName("asd");

		list.forEach(System.out::println);
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> list = studentDAO.findAll();
		list.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student object");
		Student tempStudent = new Student("qwe", "qwe", "qwe@qwe.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		Student student = studentDAO.findById(1);

		System.out.println("Found the student: " + student);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object");
		Student tempStudent1 = new Student("asd", "asd", "asd@asd.com");
		Student tempStudent2 = new Student("zxc", "zxc", "zxc@zxc.com");
		Student tempStudent3 = new Student("ewq", "ewq", "ewq@ewq.com");

		System.out.println("Saving 3 student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student 1. Generated id: " +tempStudent1.getId());
		System.out.println("Saved student 2. Generated id: " +tempStudent2.getId());
		System.out.println("Saved student 3. Generated id: " +tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student object");
		Student tempStudent = new Student("qwe", "qwe", "qwe@qwe.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " +tempStudent.getId());
	}

}
