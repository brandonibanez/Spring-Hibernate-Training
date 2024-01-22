package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student", Student.class
        );

        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastname) {
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "from Student where lastName=:lastname", Student.class
        );

        typedQuery.setParameter("lastname", lastname);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDelete = entityManager.createQuery(
                "delete from Student").executeUpdate();
        return numRowsDelete;
    }
}
