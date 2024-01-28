package com.brandoncode.cruddemo.dao;

import com.brandoncode.cruddemo.entity.Instructor;

public interface AppDAO{

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

}
