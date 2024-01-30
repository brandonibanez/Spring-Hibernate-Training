package com.brandoncode.cruddemo.dao;

import com.brandoncode.cruddemo.entity.Course;
import com.brandoncode.cruddemo.entity.Instructor;
import com.brandoncode.cruddemo.entity.InstructorDetail;
import com.brandoncode.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO{

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructorDetailById(int id);
    List<Course> findCourseByInstructorId(int id);
    Instructor findByInstructorIdJoinFetch(int id);
    void update(Instructor instructor);
    void update(Course course);
    Course findCourseById(int id);
    void deleteCourseById(int id);
    void save(Course course);
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void update(Student student);
    void deleteStudentById(int id);
}
