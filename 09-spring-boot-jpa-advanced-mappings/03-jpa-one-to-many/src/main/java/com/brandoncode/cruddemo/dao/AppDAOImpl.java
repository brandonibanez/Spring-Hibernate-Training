package com.brandoncode.cruddemo.dao;

import com.brandoncode.cruddemo.entity.Course;
import com.brandoncode.cruddemo.entity.Instructor;
import com.brandoncode.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        instructor.getCourses().forEach(
                course -> course.setInstructor(null));
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(entityManager.find(InstructorDetail.class, id));
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id= :data", Course.class
        );
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findByInstructorIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                 "Select i from Instructor i " +
                    "JOIN FETCH i.courses " +
                    "JOIN FETCH i.instructorDetail " +
                    "where i.id=:data ", Instructor.class
        );
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }
}
