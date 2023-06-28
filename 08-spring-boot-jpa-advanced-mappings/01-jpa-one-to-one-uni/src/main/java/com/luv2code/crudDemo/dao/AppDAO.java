package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
